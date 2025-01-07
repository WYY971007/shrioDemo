package com.wyy.demoshiro.entity;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class SysRole {

    private Long id;
    private String roleName; // 角色名称
    private String roleDescription; // 角色描述
    private Timestamp createdTime; // 创建时间
    private Timestamp updatedTime; // 更新时间

}
