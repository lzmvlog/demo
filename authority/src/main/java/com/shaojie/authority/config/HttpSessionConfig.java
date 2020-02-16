//package com.shaojie.authority.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.session.FindByIndexNameSessionRepository;
//import org.springframework.session.security.SpringSessionBackedSessionRegistry;
//
///**
// * @author： ShaoJie
// * @data： 2020年02月13日 18:12
// * @Description： 使用 redis 实现 session 共享 解决当集群部署时 并发会话问题
// */
//// @EnableRedisHttpSession 启用 基于redis 的 httpsession 实现
////@EnableRedisHttpSession
////@Configuration
//public class HttpSessionConfig {
//
//    /**
//     * 提供关于 redis 的连接
//     *
//     * @return
//     */
////    @Bean
////    public RedisConnectionFactory redisConnectionFactory() {
////        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
////        redisConfig.setHostName("120.78.189.213");
////        redisConfig.setPassword(RedisPassword.of("123456"));
////        redisConfig.setPort(6379);
////        redisConfig.setDatabase(0);
////        return new JedisConnectionFactory();
////    }
//
//    @Autowired
//    private FindByIndexNameSessionRepository mySessionRepository;
//
//    /**
//     * @return SpringSessionBackedSessionRegistry 是 session 为 SpringSecurity
//     * 提供的用户在集群环境下控制会话并发的会话注册表实现类
//     */
//    @Bean
//    public SpringSessionBackedSessionRegistry sessionRegistry() {
//        return new SpringSessionBackedSessionRegistry(this.mySessionRepository);
//    }
//
//    /**
//     * httpSession 的时间监听 改用 session 提供的会话注册表
//     *
//     * @return
//     */
////    @Bean
////    public HttpSessionEventPublisher httpSessionEventPublisher() {
////        return new HttpSessionEventPublisher();
////    }
//}
