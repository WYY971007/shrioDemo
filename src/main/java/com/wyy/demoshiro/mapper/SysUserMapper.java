package com.wyy.demoshiro.mapper;

import com.wyy.demoshiro.entity.SysUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface SysUserMapper {


    void insert(SysUser sysUser);

    SysUser findById(Long id);

    List<SysUser> findAll();

    void update(SysUser sysUser);

    void delete(Long id);

    SysUser findByUsername (String username);
}
