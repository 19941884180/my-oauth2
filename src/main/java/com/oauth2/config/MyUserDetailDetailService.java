package com.oauth2.config;

import com.oauth2.entity.SysPermission;
import com.oauth2.entity.SysUser;
import com.oauth2.entity.SysUserExample;
import com.oauth2.mapper.SysUserMapper;
import com.oauth2.mapper.SysUserRoleMapper;
import com.oauth2.mapper.ext.SysUserExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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
    private SysUserRoleMapper userRoleMapper;
    @Autowired
    private SysUserExtMapper sysUserExtMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(s)){
            throw new RuntimeException("用户名不能为空");
        }
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andAccoundEqualTo(s);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        if(CollectionUtils.isEmpty(sysUsers)){
            throw  new RuntimeException("用户名不存在");
        }
        SysUser sysUser = sysUsers.get(0);
        if(1!=sysUser.getState()){
            throw new RuntimeException("账户已被锁定，请联系管理员！");
        }
        List<SysPermission> permissions = sysUserExtMapper.selectPermissionByUserId(sysUser.getId());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(SysPermission permission : permissions){
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(permission.getPermissionCode());
            authorities.add(simpleGrantedAuthority);
        }
        SecuritySysUser ssu=new SecuritySysUser(sysUser.getAccound(),sysUser.getPassword(),authorities);
        ssu.setSysuser(sysUser);
        return ssu;

    }
}
