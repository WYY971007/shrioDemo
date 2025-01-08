package com.wyy.demoshiro.config;

import com.wyy.demoshiro.entity.SysUser;
import com.wyy.demoshiro.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    SysUserService sysUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证");
        UsernamePasswordToken userToken = (UsernamePasswordToken)authenticationToken;

        SysUser sysUser = sysUserService.getUserByUserName(((UsernamePasswordToken) authenticationToken).getUsername());

        if (sysUser == null) {
            return null;
        }

        // 获取数据库存储的加密密码和盐值
        String storedPassword = sysUser.getPassword();  // 从数据库中获取的加密后的密码
        String salt = sysUser.getSalt();  // 从数据库中获取的盐值

        // 使用盐值对用户输入的密码进行哈希加密
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);  // 将盐值转换为 ByteSource
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                sysUser,  // 主体：用户名
                storedPassword,      // 存储的加密后的密码
                credentialsSalt,     // 盐值
                getName()            // realm 名称
        );

        return authenticationInfo;
    }
}
