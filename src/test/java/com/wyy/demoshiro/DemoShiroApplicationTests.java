package com.wyy.demoshiro;

import com.wyy.demoshiro.service.SysUserService;
import com.wyy.demoshiro.service.impl.SysUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoShiroApplicationTests {

    @Autowired
    SysUserService sysUserService;

    @Test
    void contextLoads() {
        System.out.println(sysUserService.getUserByUserName("john_doe"));
    }

}
