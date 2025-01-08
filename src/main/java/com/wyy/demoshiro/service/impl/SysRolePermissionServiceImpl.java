package com.wyy.demoshiro.service.impl;


import com.wyy.demoshiro.entity.SysRolePermission;
import com.wyy.demoshiro.mapper.SysRolePermissionMapper;
import com.wyy.demoshiro.service.SysRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    // 插入角色权限
    @Override
    public void addRolePermission(SysRolePermission sysRolePermission) {
        sysRolePermissionMapper.insert(sysRolePermission);
    }

    // 删除角色权限
    @Override
    public void deleteRolePermission(Long roleId, Long permissionId) {
        sysRolePermissionMapper.delete(roleId, permissionId);
    }

    // 根据角色 ID 查找权限
    @Override
    public List<SysRolePermission> getRolePermissions(Long roleId) {
        return sysRolePermissionMapper.findByRoleId(roleId);
    }

    // 根据权限 ID 查找角色
    @Override
    public List<SysRolePermission> getPermissionRoles(Long permissionId) {
        return sysRolePermissionMapper.findByPermissionId(permissionId);
    }
}
