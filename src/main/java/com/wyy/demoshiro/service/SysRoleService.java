package com.wyy.demoshiro.service;

import com.wyy.demoshiro.entity.SysRole;
import com.wyy.demoshiro.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    // 插入角色
    public void addRole(SysRole sysRole) {
        sysRoleMapper.insert(sysRole);
    }

    // 根据 ID 查找角色
    public SysRole getRoleById(Long id) {
        return sysRoleMapper.findById(id);
    }

    // 查找所有角色
    public List<SysRole> getAllRoles() {
        return sysRoleMapper.findAll();
    }

    // 更新角色
    public void updateRole(SysRole sysRole) {
        sysRoleMapper.update(sysRole);
    }

    // 删除角色
    public void deleteRole(Long id) {
        sysRoleMapper.delete(id);
    }
}
