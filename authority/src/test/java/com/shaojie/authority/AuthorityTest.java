package com.shaojie.authority;

import com.shaojie.authority.jwt.JwtUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

/**
 * @author ShaoJie
 * @Date 2019年11月25 19:51
 * @Description:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorityTest {

    @Autowired
    public JwtUtil jwtUtil;

    @Test
    public void contextLoads() {
        /*long now = System.currentTimeMillis();
        long exp = now + 1000 * 30;//30秒过期
        JwtBuilder builder = Jwts.builder()
                // 设置唯一编号
                .setId("888")
                // 设置主题  可以是JSON数据
                .setSubject("小白")
                // 设置签发日期
                .setIssuedAt(new Date())
                // 设置角色
                .claim("roles", "admin")
                // 过期时间
                .setExpiration(new Date(exp))
                // 设置签名 使用HS256算法，并设置SecretKey(字符串)
                .signWith(SignatureAlgorithm.HS256, "hahaha");
        //构建 并返回一个字符串
//        System.out.println();
        String compactJwt = builder.compact();
        Claims claims = Jwts.parser().setSigningKey("hahaha").parseClaimsJws(compactJwt).getBody();
        System.out.println(claims);*/

        String token = Jwts.builder()
//        主题 放入用户名
                .setSubject("niceyoo")
//        自定义属性 放入用户拥有请求权限
                .claim("authorities", "admin")
//        失效时间
                .setExpiration(new Date(System.currentTimeMillis() + 7 * 60 * 1000))
//        签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, "tmax")
                .compact();
//        log.info("token：{}",token);
//        User shaoJie = new User().setId(1)
//                .setName("ShaoJie")
//                .setPassword("123456")
//                .setEnable(true);
//        String token = jwtUtil.createToken();
//        jwtUtil.parseToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuaWNleW9vIiwiYXV0aG9yaXRpZXMiOiJhZG1pbiIsImV4cCI6MTU4NTExNzc5MX0.9dbyn-KHOVMCzPjb2uAXMJLwonl32L2tnZvPEHhylDgie1pmQsDERtaFEObObqbPZez1huFiDhQSJkf0ssPYjQ");
    }

}
