package com.wyy.demoshiro.entity;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class SysPermission {

    private Long id;
    private String permissionName; // 权限名称
    private String permissionDescription; // 权限描述
    private String permissionType; // 权限类型（如 url, method, 等）
    private Timestamp createdTime; // 创建时间
    private Timestamp updatedTime; // 更新时间

}
