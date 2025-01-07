package com.wyy.demoshiro.mapper;


import com.wyy.demoshiro.entity.SysRole;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface SysRoleMapper {


    void insert(SysRole sysRole);

    SysRole findById(Long id);

    List<SysRole> findAll();

    void update(SysRole sysRole);

    void delete(Long id);
}
