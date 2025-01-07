package com.wyy.demoshiro.mapper;


import com.wyy.demoshiro.entity.SysUserRole;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface SysUserRoleMapper {

    void insert(SysUserRole sysUserRole);

    void delete(Long userId, Long roleId);

    List<SysUserRole> findByUserId(Long userId);

    List<SysUserRole> findByRoleId(Long roleId);
}
