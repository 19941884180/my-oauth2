package com.oauth2.service.impl;

import com.oauth2.entity.Permission;
import com.oauth2.entity.SysUser;
import com.oauth2.entity.SysUserExample;
import com.oauth2.mapper.SysUserMapper;
import com.oauth2.mapper.ext.SysUserExtMapper;
import com.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author maody
 * @date 2022/6/1 15:03
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserExtMapper sysUserExtMapper;

    @Override
    public SysUser selectByName(String name) {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUsernameEqualTo(name);
        List<SysUser> sysUsers =
                sysUserMapper.selectByExample(sysUserExample);
        if(CollectionUtils.isEmpty(sysUsers)){
            return null;
        }
        return sysUsers.get(0);
    }

    @Override
    public List<Permission> selectPermissionByUserId(Integer userId) {
        return sysUserExtMapper.selectPermissionByUserId(userId);
    }
}
