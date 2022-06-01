package com.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author maody
 * @date 2022/5/31 15:43
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService myUserDetailDetailService;

    @Autowired
    private CustomizeAuthenticationEntryPoint customizeAuthenticationEntryPoint;
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    TokenStore redisTokenStore(RedisConnectionFactory connectionFactory){
        return new RedisTokenStore(connectionFactory);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailDetailService);
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
        http
                .antMatcher("/login").authorizeRequests()
                .antMatchers("/login").permitAll()
                .and()
                .exceptionHandling().authenticationEntryPoint(customizeAuthenticationEntryPoint)
                .and()
                .csrf().disable();
    }
}
