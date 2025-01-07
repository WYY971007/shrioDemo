package com.wyy.demoshiro.service;


import com.wyy.demoshiro.entity.SysUser;
import com.wyy.demoshiro.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    // 插入用户
    public void addUser(SysUser sysUser) {
        sysUserMapper.insert(sysUser);
    }

    // 根据 ID 查找用户
    public SysUser getUserById(Long id) {
        return sysUserMapper.findById(id);
    }

    // 查找所有用户
    public List<SysUser> getAllUsers() {
        return sysUserMapper.findAll();
    }

    // 更新用户
    public void updateUser(SysUser sysUser) {
        sysUserMapper.update(sysUser);
    }

    // 删除用户
    public void deleteUser(Long id) {
        sysUserMapper.delete(id);
    }
}
