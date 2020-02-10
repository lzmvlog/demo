package com.shaojie.jdbcauthority.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * @author： ShaoJie
 * @data： 2020年01月10日 11:25
 * @Description： 安全配置
 */
@Configuration
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

    /**
     * 注入数据源
     */
    @Autowired
    public DataSource dataSource;

    /**
     * 用户详细信息 业务逻辑层
     */
//    @Autowired
//    public UsersServiceImpl userService;

//    /**
//     * 用户管理
//     *
//     * @return
//     */
//    public UserDetailsService userDetailsService() {
//        // UserDetailsManager  用户详细信息管理器
//        // 提供了很多的方法 类似 createUser(UserDetail user) 根绝提供的信息 创建一个用户
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
//        jdbcUserDetailsManager.setDataSource(dataSource);
//        return jdbcUserDetailsManager;
//    }

    /**
     * 授权
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
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
         * 这里的 varchar_ignorecase 类型 mysql 并不支持 替换成 varchar 即可
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
        // 基于 JDBC 的验证
        auth.jdbcAuthentication()
                // 设置用户角色的前缀
//                 .rolePrefix("ROLE_")
                // 添加用用户
                // .withUser(new Users())
                // 注入数据源
                .dataSource(dataSource)
                // 设置用于通过用户名查找用户的查询
                .usersByUsernameQuery("select username,password,enabled from users WHERE username=?")
                // 设置查询以通过用户名查找用户的权限
                .authoritiesByUsernameQuery("select username,authority from authorities where username=?")
                // 密码加密
                .passwordEncoder(passwordEncoder());

    }

    /**
     * 验证
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 授权请求
//                .authorizeRequests()
                // antMatchers 设置拦截的请求  hasRole 对应的角色名
                // .hasAnyAuthority("PRODUCT_ADD") 用户所具有的权限
                .antMatchers("/product/add").hasRole("USER")
                .antMatchers("/product/update").hasRole("ADMIN")
                .antMatchers("/product/list").hasRole("USER")
                .antMatchers("/product/delete").hasRole("ADMIN")
                //  access() 允许指定由任意表达式保护的URL 类似 antMatchers("/user/**").access("hasRole('USER') and hasRole('DBA')")
                // permitAll 所有的权限都能访问
                .antMatchers("/login").permitAll()
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
                // 禁用跨域的保护
                .csrf().disable();
    }
}
