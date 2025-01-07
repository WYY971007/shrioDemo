package com.wyy.demoshiro;

import com.wyy.demoshiro.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoShiroApplicationTests {

    @Autowired
    SysUserService SysUserService;

    @Test
    void contextLoads() {
        System.out.println(SysUserService.getUserById(1L));
    }

}
