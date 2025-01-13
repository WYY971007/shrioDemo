package com.wyy.demoshiro.config;

import com.wyy.demoshiro.entity.SysRole;
import com.wyy.demoshiro.entity.SysRolePermission;
import com.wyy.demoshiro.entity.SysUser;
import com.wyy.demoshiro.entity.SysUserRole;
import com.wyy.demoshiro.service.SysRolePermissionService;
import com.wyy.demoshiro.service.SysRoleService;
import com.wyy.demoshiro.service.SysUserRoleService;
import com.wyy.demoshiro.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysUserRoleService sysUserRoleService;
    @Autowired
    SysRolePermissionService sysRolePermissionService;
    @Autowired
    SysRoleService sysRoleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();

        // 获取用户角色和权限
        SysUser user = sysUserService.getUserByUserName(sysUser.getUsername());
        Set<String> roles = new HashSet<>();
        Set<String> permissions = new HashSet<>();

        // 获取用户角色
        List<SysUserRole> userRoles = sysUserRoleService.getUserRoles(user.getId());
        for (SysUserRole role : userRoles) {
            roles.add(sysRoleService.getRoleById(role.getRoleId()).getRoleName());
            // 获取角色权限
            List<String> rolePermissions = sysRolePermissionService.getPermissonByRole(role.getRoleId().toString());
            for (String permission : rolePermissions) {
                permissions.add(permission);
            }
        }

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
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
