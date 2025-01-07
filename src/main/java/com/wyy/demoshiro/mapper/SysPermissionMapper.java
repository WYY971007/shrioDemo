package com.wyy.demoshiro.mapper;

import com.wyy.demoshiro.entity.SysPermission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface SysPermissionMapper {


    void insert(SysPermission sysPermission);

    SysPermission findById(Long id);

    List<SysPermission> findAll();

    void update(SysPermission sysPermission);

    void delete(Long id);
}
