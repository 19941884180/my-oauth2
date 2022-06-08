package com.oauth2.mapper.ext;

import com.oauth2.entity.SysPermission;
import com.oauth2.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author maody
 * @date 2022/6/1 11:18
 */
public interface SysUserExtMapper {
    List<SysRole> selectRoleListByUserId(@Param("userId") Long userId);

    List<SysPermission> selectPermissionByUserId(@Param("userId") Long userId);
}
