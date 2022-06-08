package com.oauth2.service;

import com.oauth2.entity.SysPermission;
import com.oauth2.entity.SysUser;

import java.util.List;

/**
 * @author maody
 * @date 2022/6/1 15:02
 */
public interface UserService {
    SysUser selectByName(String name);

    List<SysPermission> selectPermissionByUserId(Long userId);
}
