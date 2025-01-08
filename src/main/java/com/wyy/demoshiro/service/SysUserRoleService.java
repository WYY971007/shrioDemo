package com.wyy.demoshiro.service;

import com.wyy.demoshiro.entity.SysUserRole;

import java.util.List;

public interface SysUserRoleService {
    // 插入用户角色
    
    public void addUserRole(SysUserRole sysUserRole);

    // 删除用户角色
    
    public void deleteUserRole(Long userId, Long roleId);

    // 根据用户 ID 查找角色
    
    public List<SysUserRole> getUserRoles(Long userId);

    // 根据角色 ID 查找用户
    
    public List<SysUserRole> getRoleUsers(Long roleId);
}
