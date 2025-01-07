package com.wyy.demoshiro.service;


import com.wyy.demoshiro.entity.SysPermission;
import com.wyy.demoshiro.mapper.SysPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    // 插入权限
    public void addPermission(SysPermission sysPermission) {
        sysPermissionMapper.insert(sysPermission);
    }

    // 根据 ID 查找权限
    public SysPermission getPermissionById(Long id) {
        return sysPermissionMapper.findById(id);
    }

    // 查找所有权限
    public List<SysPermission> getAllPermissions() {
        return sysPermissionMapper.findAll();
    }

    // 更新权限
    public void updatePermission(SysPermission sysPermission) {
        sysPermissionMapper.update(sysPermission);
    }

    // 删除权限
    public void deletePermission(Long id) {
        sysPermissionMapper.delete(id);
    }
}
