package com.oauth2.controller;

import com.oauth2.utils.JsonResult;
import com.oauth2.utils.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author maody
 * @date 2022/5/31 16:59
 */
@RestController
public class HelloController {
    @GetMapping("/admin/hello")
    public String admin(){
        return "hello admin";
    }

    @GetMapping("/user/hello")
    public String user(){
        return "hello user";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthorizationServerTokenServices authorizationServerTokenServices;

    @Autowired
    private ClientDetailsService clientDetailsService;

    // 提交测试
    @PostMapping("/login")
    public JsonResult login(@RequestBody Map<String,String> request) throws HttpRequestMethodNotSupportedException {
        TokenRequest tokenRequest = new TokenRequest(request, "client_id", null, "password");
        String username = request.get("username");
        String password = request.get("password");
        Authentication userAuth = new UsernamePasswordAuthenticationToken(username, password,new ArrayList<>());
        ClientDetails client = clientDetailsService.loadClientByClientId("client_id");
        userAuth = authenticationManager.authenticate(userAuth);
        OAuth2Request oauth2Request = tokenRequest.createOAuth2Request(client);
        OAuth2AccessToken accessToken = authorizationServerTokenServices.createAccessToken(new OAuth2Authentication(oauth2Request, userAuth));
        return ResultTool.success(accessToken);
    }
    @GetMapping("/getCurrentUser")
    public JsonResult getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResultTool.success(principal);
    }
}
