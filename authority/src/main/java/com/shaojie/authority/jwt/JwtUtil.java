package com.shaojie.authority.jwt;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.sql.Date;

/**
 * @author： ShaoJie
 * @data： 2020年02月22日 18:17
 * @Description： jwt 生成校验 token
 */
public class JwtUtil {

    /**
     * 创建生成 token
     *
     * @return
     */
    public String createToken() {
        //30秒过期
        long now = System.currentTimeMillis();
        long exp = now + 1000 * 30;
        // builder 构建 token
        String token = Jwts.builder()
                // 设置唯一的 id
                .setId(IdUtil.simpleUUID())
                // 设置主题
                .setSubject("")
                // 设置 token 签发的时间
                .setIssuedAt(new DateTime())
                // 设置角色
                .claim("admin", "ShaoJie")
                // 设置过期时间
                .setExpiration(new Date(exp))
                // 设置签名 使用HS256算法，并设置SecretKey(字符串)
                .signWith(SignatureAlgorithm.HS256, "hahaha")
                .compact();
        return token;
    }

}
