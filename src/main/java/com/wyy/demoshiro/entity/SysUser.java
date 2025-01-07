package com.wyy.demoshiro.entity;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class SysUser {

    private Long id;
    private String username;
    private String password;
    private String salt;  // 盐值，用于加密密码
    private String email;
    private String phone;
    private Integer status; // 状态，1：启用，0：禁用
    private Timestamp createdTime; // 创建时间
    private Timestamp updatedTime; // 更新时间

}
