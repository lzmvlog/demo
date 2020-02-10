package com.shaojie.authority;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ShaoJie
 * @Date 2019年11月25 19:51
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorityTest {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Test
    public void contextLoads() {

        System.out.println(passwordEncoder.matches("123456", "{bcrypt}$2a$10$LwAAIMgaW.K/chL97wm0UeqvnQYeC5pl4vup.fdQJOG08gJKu1oTi"));
//        System.out.println(passwordEncoder().encode("123456"));
    }

}
