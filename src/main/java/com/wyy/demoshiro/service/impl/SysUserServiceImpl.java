package com.wyy.demoshiro.service.impl;


import com.wyy.demoshiro.entity.SysUser;
import com.wyy.demoshiro.mapper.SysUserMapper;
import com.wyy.demoshiro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    // 插入用户
    @Override
    public void addUser(SysUser sysUser) {
        sysUserMapper.insert(sysUser);
    }

    // 根据 ID 查找用户
    @Override
    public SysUser getUserById(Long id) {
        return sysUserMapper.findById(id);
    }

    // 查找所有用户
    @Override
    public List<SysUser> getAllUsers() {
        return sysUserMapper.findAll();
    }

    // 更新用户
    @Override
    public void updateUser(SysUser sysUser) {
        sysUserMapper.update(sysUser);
    }

    // 删除用户
    @Override
    public void deleteUser(Long id) {
        sysUserMapper.delete(id);
    }

    @Override
    public SysUser getUserByUserName(String username) {
        return sysUserMapper.findByUsername(username);
    }
}
