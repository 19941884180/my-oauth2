package com.oauth2.controller;

import cn.hutool.core.map.MapUtil;
import com.oauth2.entity.Permission;
import com.oauth2.entity.SysUser;
import com.oauth2.service.UserService;
import com.oauth2.utils.JsonResult;
import com.oauth2.utils.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private TokenEndpoint tokenEndpoint;

    @Autowired
    private UserService userService;

    // 提交测试
    @PostMapping("/login")
    public JsonResult login(@RequestBody Map<String,String> request) throws HttpRequestMethodNotSupportedException {
        User userClient = new User("password","123456",new ArrayList<>());
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userClient,null,new ArrayList<>());
        request.put("grant_type","password");
        request.put("client_id","password");
        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(token,request).getBody();
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SysUser sysUser = userService.selectByName(MapUtil.getStr(request,"username"));
        List<Permission> permissions = userService.selectPermissionByUserId(sysUser.getId());
        sysUser.setPassword(null);
        Map<String,Object> result = new HashMap<>();
        result.put("sysUser",sysUser);
        result.put("oAuth2AccessToken",oAuth2AccessToken);
        result.put("permissions",permissions);
        return ResultTool.success(result);
    }
}
