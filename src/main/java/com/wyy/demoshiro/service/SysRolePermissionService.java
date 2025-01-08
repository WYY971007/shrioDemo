package com.wyy.demoshiro.service;

import com.wyy.demoshiro.entity.SysRolePermission;

import java.util.List;

public interface SysRolePermissionService {
    // 插入角色权限
   
    public void addRolePermission(SysRolePermission sysRolePermission);

    // 删除角色权限
   
    public void deleteRolePermission(Long roleId, Long permissionId);

    // 根据角色 ID 查找权限
   
    public List<SysRolePermission> getRolePermissions(Long roleId);

    // 根据权限 ID 查找角色
   
    public List<SysRolePermission> getPermissionRoles(Long permissionId);
}
