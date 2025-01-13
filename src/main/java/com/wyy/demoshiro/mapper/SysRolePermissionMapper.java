package com.wyy.demoshiro.mapper;

import com.wyy.demoshiro.entity.SysRolePermission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface SysRolePermissionMapper {

    void insert(SysRolePermission sysRolePermission);

    void delete(Long roleId, Long permissionId);

    List<SysRolePermission> findByRoleId(Long roleId);

    List<SysRolePermission> findByPermissionId(Long permissionId);

    List<String> getPermissonByRole(String id) ;
}
