package com.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author maody
 * @date 2022/5/31 15:43
 */
@Configuration
@EnableWebSecurity
//prePostEnabled属性决定Spring Security在接口前注解是否可用@PreAuthorize,@PostAuthorize等注解,设置为true,会拦截加了这些注解的接口
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 自定义用户登录操作
     */
    @Autowired
    private UserDetailsService myUserDetailDetailService;

    /**
     * 匿名用户访问无权限资源时的异常
     */
    @Autowired
    private CustomizeAuthenticationEntryPoint customizeAuthenticationEntryPoint;

    /**
     * 登录失败执行方法
     */
    @Autowired
    private CustomizeAuthenticationFailureHandler customizeAuthenticationFailureHandler;

    /**
     * 没有权限设置
     */
    @Autowired
    private CustomizeAccessDeniedHandler customizeAccessDeniedHandler;

    /**
     * 登出成功执行方法
     */
    @Autowired
    private CustomizeLogoutSuccessHandler customizeLogoutSuccessHandler;

    /**
     *登录成功执行方法
     * @return
     */
    @Bean
    public CustomizeAuthenticationSuccessHandler loginSuccessHandler() {
        return new CustomizeAuthenticationSuccessHandler();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * AuthenticationManager
     * <p>
     * 如果不声明，会导致授权服务器无AuthenticationManager，
     * 密码模式：而password方式无法获取token
     */

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    /**
     * 用户名密码授权管理器
     *
     * @return DaoAuthenticationProvider
     */
    @Bean
    public UserNamePasswordAuthenticationProvider daoAuthenticationProvider() {
        return new UserNamePasswordAuthenticationProvider(myUserDetailDetailService, passwordEncoder());
    }

//    @Bean
//    TokenStore redisTokenStore(RedisConnectionFactory connectionFactory){
//        return new RedisTokenStore(connectionFactory);
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
//        auth.userDetailsService(myUserDetailDetailService);
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("$2a$10$xeYXpgnvrwpBX2TPTjWgaOUGtXKvrvcJKoVllhq22EfGlOf8Q394q")
//                .roles("admin")
//                .and()
//                .withUser("user")
//                .password("$2a$10$xeYXpgnvrwpBX2TPTjWgaOUGtXKvrvcJKoVllhq22EfGlOf8Q394q")
//                .roles("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/sysUser/addUser").permitAll() // 允许post请求/add-user，而无需认证
                .antMatchers(HttpMethod.GET,"/getCurrentUser").permitAll()
                .antMatchers("/sysUser/captcha").permitAll()//验证码放过
                .antMatchers("/login/**").permitAll()//验证码放过
                .antMatchers("/oauth/**").permitAll()//oauth2 请求路径放过
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().authenticated() //   有请求都需要验证

                //登入
                .and().formLogin().
                permitAll()//允许所有用户
                .successHandler(loginSuccessHandler()).//登录成功处理逻辑
                failureHandler(customizeAuthenticationFailureHandler).//登录失败处理逻辑

                //登出
                and().logout().
                permitAll()//允许所有用户
                .logoutSuccessHandler(customizeLogoutSuccessHandler)//登出成功处理逻辑

                //异常处理(权限拒绝、登录失效等)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(customizeAuthenticationEntryPoint)//匿名用户访问无权限资源时的异常处理
                .accessDeniedHandler(customizeAccessDeniedHandler)

//                 无状态session，不进行存储 禁用session
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;
//        http.addFilterBefore(securityInterceptor, FilterSecurityInterceptor.class);
        //http.addFilterBefore(captchaFilter, UsernamePasswordAuthenticationFilter.class);

//        http
//                .antMatcher("/login").authorizeRequests()
//                .antMatchers("/login").permitAll()
//                .and()
//                .exceptionHandling().authenticationEntryPoint(customizeAuthenticationEntryPoint)
//                .and()
//                .csrf().disable();
    }
}
