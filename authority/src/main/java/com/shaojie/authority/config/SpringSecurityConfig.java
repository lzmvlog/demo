package com.shaojie.authority.config;

import com.shaojie.authority.model.Purview;
import com.shaojie.authority.security.MyAuthenticationProvider;
import com.shaojie.authority.security.UserDetailsServiceImpl;
import com.shaojie.authority.service.impl.PurviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @author ShaoJie
 * @Date 2019/10/25
 */
@Configuration
// 启动 SpringSecurity 的过滤器链
@EnableWebSecurity
//@EnableRedisHttpSession
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
     * 用户信息服务
     *
     * @return
     */
    @Bean
    public UserDetailsServiceImpl userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    /**
     * 注入数据源
     * 数据源只在 jdbc 校验权限时才需要
     */
//    @Autowired
//    public DataSource dataSource;

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

    /**
     * 请求拦截器
     */
//    @Autowired
//    public RequestFilter requestFilter;
//    @Autowired
//    private AuthenticationProvider authenticationProvider;
//    @Qualifier
//    private MyAuthenticationProvider myAuthenticationProvider;
//    @Bean
//    public MyAuthenticationProvider myAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder){
//        return new MyAuthenticationProvider(this.userDetailsService,this.passwordEncoder());
//    }

//    @Bean
//    public HttpSessionEventPublisher httpSessionEventPublisher(){
//        return new HttpSessionEventPublisher();
//    }

//    @Autowired
//    private SpringSessionBackedSessionRegistry redisSessionRegistry;

//    @Autowired
//    private DigestAuthenticationEntityPoint digestAuthenticationEntityPoint;

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
        /**
         * 根据传入的自定义{@link AuthenticationProvider}添加身份验证。
         * 由于{@link AuthenticationProvider}实现是未知的，因此所有*自定义操作必须在外部完成，
         * 并且{@link AuthenticationManagerBuilder} *会立即返回。
         */
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

        http
                .authorizeRequests()
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
                // 验证码信息 处理器
//                .authenticationDetailsSource(myWebAuthenticationDetailsSource)
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
                // 会话管理
                .sessionManagement()
                // 设置最大的会话数
                .maximumSessions(1)
                // 阻止 新会话登录 默认为 false
                .maxSessionsPreventsLogin(true)
//                .sessionRegistry(redisSessionRegistry)
                // 前后端分离采用JWT 不需要session
                // sessionCreationPolicy 允许指定 session 创建政策
                // ALWAYS 始终创建一个 session
                // NEVER  Spring Security永远不会创建{@link HttpSession}，但是会使用* {@link HttpSession}（如果已经存在）
                // IF_REQUIRED  如果需要，Spring Security将仅创建一个{@link HttpSession}
                // STATELESS Spring Security永远不会创建{@link HttpSession} 并且永远不会使用它来获取
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
                // 防御固定的会话攻击的方式有四种：
                // none() ：不做任何变动 ，登录之后沿用旧的 session
                // newSession() ： 登录之后创建一个新的 session
                // migrateSession() : 登录之后创建一个新的 session 并将旧的 session 中的数据复制过来
                // changeSessionId() ： 不创建新的会话 而是使用由 servlet 容器提供的会话固定会话保护
//                .sessionFixation().none()
                // 会话过期 跳转的 URl
//                .invalidSessionUrl("/403")
                // 自定义会话过期策略
//                .invalidSessionStrategy(new MyInvalidSessionStrategy())
                // 最大会话数
                .and()
                // 添加过滤器 将 过滤器添加在 UsernamePasswordAuthenticationFilter 之前 也就是在验证账号密码之前
                // 自定义实现 用户登录拦截 之前
//                .addFilterBefore(new VerificationCodeFilter(),
//                        UsernamePasswordAuthenticationFilter.class)
                // 添加自定义的拦截器 在账号密码验证正确之后
                // .addFilterAfter(new RequestFilter(), UsernamePasswordAuthenticationFilter.class)
                .and()
                // 启用 CORS 支持
                .cors()
                .and()
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        // 禁用跨域的保护
//                .disable();
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

    /**
     * 配置 CORS 支持
     * CORS 配置源 ------ 核心实现 DefaultCorsProcessor
     *
     * @return CORS 配置文件
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许从百度站点跨域 这里的参数是一个 List 集合 少量数据测试 不需要读取数据库了
        corsConfiguration.setAllowedOrigins(Arrays.asList("https://www.baidu.com/"));
        // 允许使用 GET POST 方法
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST"));
        // 允许携带凭证
        corsConfiguration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        // 对所有的 URL 生效
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

//    @Bean
//    public CorsFilter corsFilter() {
//        //1.添加CORS配置信息
//        CorsConfiguration config = new CorsConfiguration();
//        //放行哪些原始域
//        config.addAllowedOrigin("*");
//        //是否发送Cookie信息
//        config.setAllowCredentials(true);
//        //放行哪些原始域(请求方式)
//        config.addAllowedMethod("*");
//        //放行哪些原始域(头部信息)
//        config.addAllowedHeader("*");
//        //暴漏刷新token的header
//        config.addExposedHeader(AlipayAppletSecurityConstants.RFRESH_TOKEN_HEADER_NAME);
//        //2.添加映射路径
//        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
//        configSource.registerCorsConfiguration("/alipay-applet/**", config);
//
//        //3.返回新的CorsFilter.
//        return new CorsFilter(configSource);
//    }

}