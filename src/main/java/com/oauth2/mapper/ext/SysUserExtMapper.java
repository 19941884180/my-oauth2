package com.oauth2.mapper.ext;

import com.oauth2.entity.Permission;
import com.oauth2.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author maody
 * @date 2022/6/1 11:18
 */
public interface SysUserExtMapper {
    List<Role> selectRoleListByUserId(@Param("userId") Long userId);

    List<Permission> selectPermissionByUserId(@Param("userId") Long userId);
}
