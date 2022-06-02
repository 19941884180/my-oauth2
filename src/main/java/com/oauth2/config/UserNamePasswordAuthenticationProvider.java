package com.oauth2.config;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

/**
 * @author maody
 * @date 2022/6/2 15:19
 */
public class UserNamePasswordAuthenticationProvider extends DaoAuthenticationProvider {
    /**
     * 构造方法
     *
     * @param userDetailsService 用户信息服务
     * @param passwordEncoder    密码工具
     */
    public UserNamePasswordAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this(userDetailsService, passwordEncoder, null);
    }
    /**
     * 构造方法
     *
     * @param userDetailsService         用户信息服务
     * @param passwordEncoder            密码工具
     * @param userDetailsPasswordService 修改密码服务
     */
    public UserNamePasswordAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder, UserDetailsPasswordService userDetailsPasswordService) {
        super();
        setUserDetailsService(userDetailsService);
        setPasswordEncoder(passwordEncoder);
        setUserDetailsPasswordService(userDetailsPasswordService);
    }

    /**
     * 验证通过后，查询权限等信息
     *
     * @param principal      principal
     * @param authentication authentication
     * @param user           user
     * @return org.springframework.security.core.Authentication
     */
    @Override
    protected Authentication createSuccessAuthentication(Object principal, Authentication authentication, UserDetails user) {
        Set<GrantedAuthority> authorities;
        SecuritySysUser securityUser = (SecuritySysUser) user;
        return super.createSuccessAuthentication(principal, authentication, securityUser);
    }
}
