package com.shaojie.authority.security;

import com.shaojie.authority.model.Purview;
import com.shaojie.authority.service.impl.PurviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.util.List;

/**
 * @author ShaoJie
 * @Date 2019/10/25
 */
@Configuration
// 启动 SpringSecurity 的过滤器链
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 密码加密
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsServiceImpl userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    /**
     * 注入数据源
     * 数据源只在 jdbc 校验权限时才需要
     */
    @Autowired
    public DataSource dataSource;

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

    @Autowired
    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> myWebAuthenticationDetailsSource;

//    @Autowired
//    private AuthenticationProvider authenticationProvider;
    @Qualifier
    private MyAuthenticationProvider myAuthenticationProvider;

    /**
     * 授权
     *
     * @param auth
     * @throws Exception
     */
    // 代替配置文件 <security:authentication-manager></security:authentication-manager>
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 老版本的角色设置 在  springboot 2.0 以后 不能这样设置
//        auth.inMemoryAuthentication()
//                .withUser("shaojie").password("123456")
//                .authorities("PRODUCT_ADD");

        // inMemoryAuthentication 内存验证
//        auth.inMemoryAuthentication()
//                .passwordEncoder(passwordEncoder())
//                .withUser("shaojie")
//                .password(passwordEncoder().encode("123456"))
//                // .roles("PRODUCT_ADD","PRODUCT_LIST");
//                // authorities 和 roles 都是设置权限 这里使用 roles 不能访问 403
//                .authorities("PRODUCT_ADD", "PRODUCT_LIST");

//        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());

        // 基于 JDBC 的验证
        /**
         * 地址：org.springframework.security.core.userdetails.jdbc.users.ddl
         *
         * create table users(
         *      username varchar_ignorecase(50) not null primary key,
         *      password varchar_ignorecase(500) not null,
         *      enabled boolean not null
         * );
         * create table authorities (
         *      username varchar_ignorecase(50) not null,
         *      authority varchar_ignorecase(50) not null,
         *      constraint fk_authorities_users foreign key(username) references users(username)
         * );
         * create unique index ix_auth_username on authorities (
         *      username,authority
         * );
         *
         * create table users(
         *      username varchar(50) not null primary key,
         *      password varchar(500) not null,
         *      enabled boolean not null
         * );
         * create table authorities (
         *      username varchar(50) not null,
         *      authority varchar(50) not null,
         *      constraint fk_authorities_users foreign key(username) references users(username)
         * );
         * create unique index ix_auth_username on authorities (
         *      username,authority
         * );
         */
//        auth.jdbcAuthentication()
//                // 设置用户角色的前缀
//                // .rolePrefix("ROLE_")
//                // 添加用用户
//                // .withUser(new Users())
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username,password,enabled from users WHERE username=?")
//                .authoritiesByUsernameQuery("select username,authority from authorities where username=?")
//                .passwordEncoder(passwordEncoder());

        // 基于 数据库验证
//        auth.userDetailsService(userDetailsService());
        auth.authenticationProvider(new MyAuthenticationProvider(userDetailsService, passwordEncoder()));
//        auth.authenticationProvider(myAuthenticationProvider);
    }

    /**
     * 验证
     *
     * @param http
     * @throws Exception
     */
    // 代替配置文件 <security:http></security:http>
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 添加权限
        selectPurview(http);

        http.authorizeRequests()
                // antMatchers 设置拦截的请求  hasAnyAuthority 对应的权限名称
                // .hasAnyAuthority("PRODUCT_ADD") 用户所具有的权限
                // 可替换成 .hasRole() 针对角色做验证
//                .antMatchers("/product/add").hasAnyAuthority("PRODUCT_ADD")
//                .antMatchers("/product/update").hasAnyAuthority("PRODUCT_UPDATE")
//                .antMatchers("/product/list").hasAnyAuthority("PRODUCT_LIST")
//                .antMatchers("/product/delete").hasAnyAuthority("PRODUCT_DELETE")
                // permitAll 所有的权限都能访问
                .antMatchers("/login").permitAll()
                .antMatchers("/captcha.jpg").permitAll()
//                .antMatchers("/**")
                // fullyAuthenticated 不允许匿名用户查看
//                .fullyAuthenticated()
                // 设置所有的请求都必须经过验证才能访问
                .anyRequest().authenticated()
                .and()
                // httpbasic 登录
                // .httpBasic();
                // 表单登录
                .formLogin()
                //  登录请求的页面
                .loginPage("/login")
                // 处理登录请求的 地址
                .loginProcessingUrl("/index")
                .authenticationDetailsSource(myWebAuthenticationDetailsSource)
                // 定义 故障处理器
//                 .failureHandler()
                // 修改 spring 提供的 默认登陆参数
                .usernameParameter("userName")
                .passwordParameter("password")
                .and()
                // 开启记住我功能
                .rememberMe()
                .and()
                // 开启登出
                .logout()
                .and()
                //添加过滤器 将 过滤器添加在 UsernamePasswordAuthenticationFilter 之前 也就是在验证账号密码之前
//                .addFilterBefore(new VerificationCodeFilter(),
//                        UsernamePasswordAuthenticationFilter.class)
                // 禁用跨域的保护
                .csrf().disable();
    }

    /**
     * 查询权限并将权限放入 security 中
     *
     * @param http
     * @throws Exception
     */
    public void selectPurview(HttpSecurity http) throws Exception {
        List<Purview> purviews = purviewService.selectPurview();
        for (Purview purview : purviews) {
            http.authorizeRequests()
                    .antMatchers(purview.getUrl()).hasAnyAuthority(purview.getAuthority());
        }
    }
}
