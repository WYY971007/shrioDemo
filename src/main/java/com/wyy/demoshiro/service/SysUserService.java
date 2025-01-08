package com.wyy.demoshiro.service;

import com.wyy.demoshiro.entity.SysUser;

import java.util.List;

public interface SysUserService {
    // 插入用户
    public void addUser(SysUser sysUser);

    // 根据 ID 查找用户
    public SysUser getUserById(Long id);

    // 查找所有用户
    public List<SysUser> getAllUsers() ;

    // 更新用户
    public void updateUser(SysUser sysUser);

    // 删除用户
    public void deleteUser(Long id);

    // 根据 用户名 查找用户
    public SysUser getUserByUserName(String username);
}
