package com.wyy.demoshiro.service;

import com.wyy.demoshiro.entity.SysRole;

import java.util.List;

public interface SysRoleService {

    // 插入角色
    public void addRole(SysRole sysRole);

    // 根据 ID 查找角色
    public SysRole getRoleById(Long id);

    // 查找所有角色
    public List<SysRole> getAllRoles();

    // 更新角色
    public void updateRole(SysRole sysRole);
    // 删除角色
    public void deleteRole(Long id);
}
