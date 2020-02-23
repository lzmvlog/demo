//package com.shaojie.authority.jwt;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import javax.crypto.SecretKey;
//import java.util.Date;
//
///**
// * @author： ShaoJie
// * @data： 2020年02月22日 18:17
// * @Description： jwt 入门
// */
//public class JwtDemo {
//
//    public static String createJWT() {
//        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//        SecretKey secretKey = generalKey();
//        JwtBuilder builder = Jwts.builder()
//                .setId(id)                                      // JWT_ID
//                .setAudience("")                                // 接受者
//                .setClaims(null)                                // 自定义属性
//                .setSubject("")                                 // 主题
//                .setIssuer("")                                  // 签发者
//                .setIssuedAt(new Date())                        // 签发时间
//                .setNotBefore(new Date())                       // 失效时间
//                .setExpiration(long)                                // 过期时间
//                .signWith(signatureAlgorithm, secretKey);           // 签名算法以及密匙
//        return builder.compact();
//    }
//
//    public static Claims parseJWT(String jwt) throws Exception {
//        SecretKey secretKey = generalKey();
//        return Jwts.parser()
//                .setSigningKey(secretKey)
//                .parseClaimsJws(jwt)
//                .getBody();
//    }
//}
