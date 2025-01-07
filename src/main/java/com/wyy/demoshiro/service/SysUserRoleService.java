package com.wyy.demoshiro.service;


import com.wyy.demoshiro.entity.SysUserRole;
import com.wyy.demoshiro.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    // 插入用户角色
    public void addUserRole(SysUserRole sysUserRole) {
        sysUserRoleMapper.insert(sysUserRole);
    }

    // 删除用户角色
    public void deleteUserRole(Long userId, Long roleId) {
        sysUserRoleMapper.delete(userId, roleId);
    }

    // 根据用户 ID 查找角色
    public List<SysUserRole> getUserRoles(Long userId) {
        return sysUserRoleMapper.findByUserId(userId);
    }

    // 根据角色 ID 查找用户
    public List<SysUserRole> getRoleUsers(Long roleId) {
        return sysUserRoleMapper.findByRoleId(roleId);
    }
}
