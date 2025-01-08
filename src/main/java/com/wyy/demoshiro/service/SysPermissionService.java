package com.wyy.demoshiro.service;

import com.wyy.demoshiro.entity.SysPermission;

import java.util.List;

public interface SysPermissionService {

    // 插入权限

    public void addPermission(SysPermission sysPermission);

    // 根据 ID 查找权限

    public SysPermission getPermissionById(Long id) ;

    // 查找所有权限

    public List<SysPermission> getAllPermissions();

    // 更新权限

    public void updatePermission(SysPermission sysPermission);

    // 删除权限

    public void deletePermission(Long id);
}
