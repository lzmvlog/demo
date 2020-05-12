package com.shaojie.authority.jwt;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import com.shaojie.authority.exception.TokenException;
import com.shaojie.authority.service.impl.AuthorityServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;

/**
 * @author： ShaoJie
 * @data： 2020年02月22日 18:17
 * @Description： jwt 生成校验 token
 */
@Slf4j
@Configuration
public class JwtUtil {

    String signingKey = "SigningKey";

    /**
     * 权限服务
     */
    @Autowired
    private AuthorityServiceImpl authorityService;

    /**
     * 创建生成 token
     *
     * @return
     */
    public String createToken() {
        //30秒过期
        long now = System.currentTimeMillis();
        long exp = now + 1000 * 60;
        // builder 构建 token
        String token = Jwts.builder()
                // 设置唯一的 id
                .setId(IdUtil.simpleUUID())
                // 设置主题
                .setSubject("token")
                // 设置角色
//                .claim("admin", "ShaoJie")
//                .claim("authorities", "admin")
                // 设置角色集
//                .addClaims()
                // 设置过期时间
                .setExpiration(new Date(exp))
                // 设置 token 签发的时间
                .setIssuedAt(new DateTime())
                // 设置签名 使用HS256算法，并设置SecretKey(字符串)  签名算法和秘钥
                .signWith(SignatureAlgorithm.HS256, signingKey)
                // 以下内容构建JWT并将其序列化为紧凑的，URL安全的字符串
                .compact();
        log.info("token:{}", token);
        return token;
    }

    /**
     * 解析 token
     *
     * @param token 用户的 token
     */
    public void parseToken(String token) throws TokenException {
        Claims claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
        if (claims.equals(null))
            throw new TokenException();
        log.info("解析的数据：{}", claims);
    }

    public static void main(String[] args) {
        JwtUtil jwtUtil = new JwtUtil();
//        String token = jwtUtil.createToken();
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIzZWJmZjVjYTc4N2I0OWY0YTczNGJmMmY4Yzg5YTMxZSIsInN1YiI6InRva2VuIiwiZXhwIjoxNTg3ODkzNzY0LCJpYXQiOjE1ODc4OTM3MDV9.1F75dmR5IvesSQhLmxaySRB8RnnnOvpzctnp--pG4w4";
        try {
            jwtUtil.parseToken(token);
        } catch (TokenException e) {
            log.info("token 过期");
//            e.printStackTrace();
        }
        System.out.println(token);
    }

}