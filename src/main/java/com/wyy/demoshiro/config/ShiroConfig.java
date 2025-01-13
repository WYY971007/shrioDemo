package com.wyy.demoshiro.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
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
        // 配置静态资源过滤：需要登录认证

        shiroFilterFactoryBean.setLoginUrl("/tologin");
        filterChainDefinitionMap.put("/user/add", "authc");
        filterChainDefinitionMap.put("/user/update", "perms[edit_profile]");
//        filterChainDefinitionMap.put("/user/add", "roles[Admin]");
        // 将filterChainDefinitionMap设置到ShiroFilterFactoryBean
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("SHA-256");  // 设置哈希算法（例如 SHA-256）
        matcher.setHashIterations(1024);          // 设置哈希迭代次数
        matcher.setStoredCredentialsHexEncoded(true);  // 密码是否以十六进制编码存储
        return matcher;
    }

    @Bean
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(15000);  // 30分钟超时
        return sessionManager;
    }

}
