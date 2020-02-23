package com.shaojie.authority.security;

import com.shaojie.authority.component.MyWebAuthenticationDetails;
import com.shaojie.authority.exception.VerificationCodeException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

/**
 * @author： ShaoJie
 * @data： 2020年02月10日 20:26
 * @Description： 自定义认证过程
 * <p>
 * 因为 DaoAuthenticationProvider 也是继承的 AbstractUserDetailsAuthenticationProvider
 * 所以这里就只继承 DaoAuthenticationProvider
 */
public class MyAuthenticationProvider extends DaoAuthenticationProvider {

    /**
     * 用户认证提供者
     */
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 密码加密
     */
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public PasswordEncoder passwordEncoder;

    public MyAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.setUserDetailsService(userDetailsService);
        this.setPasswordEncoder(passwordEncoder);
    }

    /**
     * 允许子类针对给定的身份验证请求对返回的（或缓存的）UserDetails 进行任何其他检查。
     * 通常，子类至少会将 Authentication＃getCredentials（）与 UserDetails＃getPassword（）比较。
     * 如果需要自定义逻辑来比较 UserDetails 和或
     * UsernamePasswordAuthenticationToken 的其他*属性，则这些属性也应出现在此方法中。
     *
     * @param userDetails    用户信息
     * @param authentication 认证方式
     * @throws AuthenticationException SneakyThrow 将避免javac坚持要求您捕获或向前抛出方法主体中语句声明它们生成的所有检查异常。
     */
    @SneakyThrows
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        // getCredentials() 属于 authentication 通常用来获取主体的凭据 通常为用户的密码
        // 这里的自定义密码校验是 MyAuthenticationProvider 继承  AbstractUserDetailsAuthenticationProvider
        if (authentication.getCredentials() == null) {
            throw new BadCredentialsException(
                    this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials",
                            "密码不能为空"));
        } else {
            String password = authentication.getCredentials().toString();
            if (!password.equals(userDetails.getPassword())) {
                this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials",
                        "密码错误");
            }
        }
        // 当修改了继承的类 现在实现图形验证码的 自定义
        // 实现图片验证码的逻辑
        MyWebAuthenticationDetails details = (MyWebAuthenticationDetails) authentication.getDetails();
        // 验证 验证码是正确
        if (!details.getImageCodeIsRight()) {
            throw new VerificationCodeException();
        }

        // --------------------------
        // 以下 全是 jwt 生成 token
        // 签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//        SecretKey secretKey = generalKey();
        String builder = Jwts.builder()
                // JWT_ID
//                .setId(id)
                // 接受者
                .setAudience("")
                // 自定义属性
                .setClaims(null)
                // 主题
                .setSubject("")
                // 签发者
                .setIssuer("")
                // 签发时间
                .setIssuedAt(new Date())
                // 失效时间
                .setNotBefore(new Date())
                // 过期时间
                .setExpiration(new Date(System.currentTimeMillis() + 100 * 30))
                // 签名算法以及密匙
//                .signWith(signatureAlgorithm, secretKey);
                // 将复杂的 jwt 验证 token 转化为安全的 String 字符串
                .compact();
        // 使用父类的方法完成密码验证
//        super.additionalAuthenticationChecks(userDetails, authentication);
    }

    /**
     * 检索用户
     * 根据用户名找到用户。在实际的实现中，
     * 搜索可能区分大小写，或者不区分大小写，
     * 具体取决于实现实例的配置方式。在这种情况下，返回的UserDetails 对象的用户名可能与实际请求的不同。
     *
     * @param username       用户的账号
     * @param authentication 认证方式
     * @return
     * @throws AuthenticationException 认证异常
     */
   /*@Override
    protected UserDetails retrieveUser(String username,
                                       UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        return userDetailsService.loadUserByUsername(username);
    }*/
}