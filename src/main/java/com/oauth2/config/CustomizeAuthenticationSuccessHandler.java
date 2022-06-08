package com.oauth2.config;

import cn.hutool.json.JSONUtil;
import com.oauth2.constants.Constant;
import com.oauth2.utils.JsonResult;
import com.oauth2.utils.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author maody
 * @date 2022/6/2 14:24
 * .登录成功处理
 */
@Component
public class CustomizeAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private AuthorizationServerTokenServices authorizationServerTokenServices;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        //此处还可以进行一些处理，比如登录成功之后可能需要返回给前台当前用户有哪些菜单权限，
        //进而前台动态的控制菜单的显示等，具体根据自己的业务需求进行扩展
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user);
        //获取生成得token
        String header = request.getHeader(Constant.AUTHORIZATION);
        if (header == null || !header.startsWith("Basic ")) {
            throw new UnapprovedClientAuthenticationException("请求头中无client信息");
        }
        String[] tokens = this.extractAndDecodeHeader(header, request);
        String clientId = tokens[0];
        String clientSecret = tokens[1];
// 2. 通过 ClientDetailsService 获取 ClientDetails
        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
//        String secret=clientDetails.getClientSecret();
//        clientSecret=passwordEncoder.encode(clientSecret);
        TokenRequest tokenRequest = null;
        // 3. 校验 ClientId和 ClientSecret的正确性
        if (clientDetails == null) {
            throw new UnapprovedClientAuthenticationException("clientId:" + clientId + "对应的信息不存在");
        }
//        else if (passwordEncoder.matches(clientSecret,clientDetails.getClientSecret())) {
//            throw new UnapprovedClientAuthenticationException("clientSecret不正确");
//        }
        else {
            // 4. 通过 TokenRequest构造器生成 TokenRequest
            tokenRequest = new TokenRequest(new HashMap<>(), clientId, clientDetails.getScope(), "password");
        }
        // 5. 通过 TokenRequest的 createOAuth2Request方法获取 OAuth2Request
        OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);
        // 6. 通过 Authentication和 OAuth2Request构造出 OAuth2Authentication
        OAuth2Authentication auth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);

        // 7. 通过 AuthorizationServerTokenServices 生成 OAuth2AccessToken
        OAuth2AccessToken token = authorizationServerTokenServices.createAccessToken(auth2Authentication);

        //此处还可以进行一些处理，比如登录成功之后可能需要返回给前台当前用户有哪些菜单权限，
        //进而前台动态的控制菜单的显示等，具体根据自己的业务需求进行扩展

        Map<String,String> results = new HashMap<>();
        results.put(Constant.AUTHORIZATION,JSONUtil.toJsonStr(token));
        //返回json数据
        JsonResult result = ResultTool.success(results);
        //处理编码方式，防止中文乱码的情况
        response.setContentType("text/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        response.getWriter().write(JSONUtil.toJsonStr(result));
    }

    private String[] extractAndDecodeHeader(String header, HttpServletRequest request) {
        byte[] base64Token = header.substring(6).getBytes(StandardCharsets.UTF_8);

        byte[] decoded;
        try {
            decoded = Base64.getDecoder().decode(base64Token);
        } catch (IllegalArgumentException var7) {
            throw new BadCredentialsException("Failed to decode basic authentication token");
        }

        String token = new String(decoded, StandardCharsets.UTF_8);
        int delim = token.indexOf(":");
        if (delim == -1) {
            throw new BadCredentialsException("Invalid basic authentication token");
        } else {
            return new String[]{token.substring(0, delim), token.substring(delim + 1)};
        }
    }
}
