package com.shaojie.authority.config;

import com.shaojie.authority.security.MyAuthenticationProvider;
import com.shaojie.authority.security.UserDetailsServiceImpl;
import com.shaojie.authority.service.impl.PurviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author： ShaoJie
 * @data： 2020年03月25日 20:21
 * @Description： 新增 SpringSecurity  + JWT 做权限校验
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SpringSecurityJwtConfig extends WebSecurityConfigurerAdapter {

    /**
     * 密码加密
     * <p>
     * -- 在 com.shaojie.authority.config.SpringSecurityConfig
     * 中 注册过  passwordEncoder 这里不能加 @Bean 进行重复注册
     *
     * @return
     */
    @Autowired
    public BCryptPasswordEncoder passwordEncoder;

    /**
     * 用户详细信息 业务逻辑层
     */
    @Autowired
    public UserDetailsServiceImpl userDetailsService;

    /**
     * 权限范围
     */
    @Autowired
    public PurviewServiceImpl purviewService;

    /**
     * @param auth 身份验证管理器生成器
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 根据传入的自定义{@link AuthenticationProvider}添加身份验证。
        // 由于{@link AuthenticationProvider}实现是未知的，
        // 因此所有*自定义操作必须在外部完成，并且{@link AuthenticationManagerBuilder} *会立即返回。
        auth.authenticationProvider(new MyAuthenticationProvider(userDetailsService, passwordEncoder));
    }

    /**
     * @param http {@link HttpSecurity} 与*名称空间配置中的Spring Security的XML <http>元素相似。
     *             它允许为特定的http *请求配置基于Web的安全性。默认情况下，
     *             它将应用于所有请求，但可以使用*
     *             {@link  requestMatcher（RequestMatcher）}或d。
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/captcha.jpg").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/index")
                .usernameParameter("userName")
                .passwordParameter("password")
                .and()
                // 跨站请求伪造
                .csrf().disable()
                // 跨站资源共享
                .cors().disable();
    }

}
