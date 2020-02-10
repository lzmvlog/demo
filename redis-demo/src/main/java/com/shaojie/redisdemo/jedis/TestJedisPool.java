package com.shaojie.redisdemo.jedis;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author： ShaoJie
 * @data： 2020年01月30日 17:26
 * @Description： 使用连接池 连接 redis
 */
@Slf4j
public class TestJedisPool {

    public static void main(String[] args) {
        // 设置连接池的配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 设置连接池参数
        jedisPoolConfig.setMaxTotal(30);
        // 最大空闲数
        jedisPoolConfig.setMaxIdle(10);

        // 获取连接池对象
        @Cleanup JedisPool jedisPool = new JedisPool(jedisPoolConfig, "120.78.189.213", 6379);

        // 客户端对象
        @Cleanup Jedis jedis = jedisPool.getResource();
        jedis.auth("123456");
        log.info("name: {}",jedis.get("name"));
    }

}
