package com.shaojie.jdbcauthority;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class JdbcAuthorityApplicationTests {

    @Test
    void contextLoads() {
        //用户密码
        String password = "123456";
        //密码加密
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String newPassword = passwordEncoder.encode(password);//加密
        System.out.println("加密密码为："+newPassword);
    }

}
