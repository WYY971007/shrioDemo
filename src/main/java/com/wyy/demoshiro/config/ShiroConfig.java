package com.wyy.demoshiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    @Bean
    public DefaultWebSecurityManager DefaultWebSecurityManager(UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);  // 设置Realm
        return securityManager;
    }

    // ShiroFilter工厂方法
    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        // 配置过滤器链
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 配置静态资源过滤：不需要认证
        filterChainDefinitionMap.put("/user/**", "authc");
//        // 配置登录页面：不需要认证
//        filterChainDefinitionMap.put("/login", "anon");
//        // 配置登出页面：登出
//        filterChainDefinitionMap.put("/logout", "logout");
//        // 配置所有/admin/**路径需要admin角色
//        filterChainDefinitionMap.put("/admin/**", "roles[admin]");
//        // 配置所有/user/**路径需要认证
//        filterChainDefinitionMap.put("/user/**", "authc");
//        // 其他路径都需要认证
//        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setLoginUrl("/tologin");
        // 将filterChainDefinitionMap设置到ShiroFilterFactoryBean
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }
}
