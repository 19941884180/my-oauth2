package com.oauth2.config;

import com.oauth2.entity.*;
import com.oauth2.mapper.SysUserMapper;
import com.oauth2.mapper.UserRoleMapper;
import com.oauth2.mapper.ext.SysUserExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maody
 * @date 2022/6/1 10:18
 */
@Service
public class MyUserDetailDetailService implements UserDetailsService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private SysUserExtMapper sysUserExtMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUsernameEqualTo(s);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        if(CollectionUtils.isEmpty(sysUsers)){
            throw  new RuntimeException("用户名不存在");
        }
        SysUser sysUser = sysUsers.get(0);
        List<Role> roles = sysUserExtMapper.selectRoleListByUserId(sysUser.getUserId());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Role role : roles){
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getRoleCode());
            authorities.add(simpleGrantedAuthority);
        }
        return new User(sysUser.getUsername(),sysUser.getPassword(),authorities);

    }
}
