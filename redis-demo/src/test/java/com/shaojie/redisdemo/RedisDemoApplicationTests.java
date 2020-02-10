package com.shaojie.redisdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.nio.charset.StandardCharsets;

@SpringBootTest
@Slf4j
class RedisDemoApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean(name="redisTemplate")
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        template.setConnectionFactory(factory);
        //key序列化方式
        template.setKeySerializer(redisSerializer);
        //value序列化
        template.setValueSerializer(redisSerializer);
        //value hashmap序列化
        template.setHashValueSerializer(redisSerializer);
        //key haspmap序列化
        template.setHashKeySerializer(redisSerializer);
        return template;
    }

    @Bean
    public StringRedisSerializer redisSerializer(){
        return new StringRedisSerializer(StandardCharsets.UTF_8);
    }

    @Test
    void contextLoads() {
        redisTemplate.boundValueOps("key").set("123456");
        Object key = redisTemplate.boundValueOps("key").get();
        log.info(String.valueOf(key));
    }

}
