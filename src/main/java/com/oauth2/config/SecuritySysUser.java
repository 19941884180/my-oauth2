package com.oauth2.config;

import com.oauth2.entity.SysRole;
import com.oauth2.entity.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

/**
 * @author maody
 * @date 2022/6/2 15:20
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class SecuritySysUser extends User {
    /**
     * 用户信息
     */
    private SysUser sysuser;
    /**
     * 权限信息
     */
    private List<SysRole> roleList;
    /**
     * 构造方法
     * @param username
     * @param password
     * @param authorities  用户权限列表
     */
    public SecuritySysUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, true, true, true, true, authorities);
    }
}
