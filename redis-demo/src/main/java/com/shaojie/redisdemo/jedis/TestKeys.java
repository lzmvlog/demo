package com.shaojie.redisdemo.jedis;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author： ShaoJie
 * @data： 2020年01月30日 17:54
 * @Description： 使用 jedis 操作 keys
 */
@Slf4j
public class TestKeys {

    @Test
    public void testKeys() {
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
        // 设置访问密码
        jedis.auth("123456");

        log.info("操作命令  --- redis返回的信息");
        // log.info("清空数据库 flushdb --- {}", jedis.flushDB());
        // 存在返回 true 否则 flase
        // log.info("判断值是否存在 exists --- {}", jedis.exists("name"));
        // 新增 keys
        // log.info("新增值 --- {}", jedis.set("userName", "ShaoJie"));
        // 获取 所有的 keys 只展示 名称 不展示具体的值
        // Set<String> keys = jedis.keys("*");
        // log.info("查看所有的值 keys * --- {}", keys);
        // 删除 key
        // log.info("删除 del key --- {}", jedis.del("userName"));
        // 查看 key 的类型
        // log.info("查看 key 的类型 --- {}", jedis.type("name"));
        // 随机返回一个值
        log.info("随机返回一个 key 值  randomkey --- {}", jedis.randomKey());
        // 修改一个 key 的名称 返回的是 ok
        // log.info("修改一个 key 值 rename --- {}", jedis.rename("name","names"));
        // 取值
        log.info("取 key 值 get --- {}", jedis.get("names"));
        // 切换数据库 select
        log.info("切换数据库 key 值 index --- {}", jedis.select(0));
        // 获取数据库中所具有的 key 的数量 返回具体的值
        log.info("获取数据库中所具有的 key 的数量 dbSize --- {}", jedis.dbSize());
        // 删除 redis 中的所有数据库的 key
        log.info("清空数据库 flushAll --- {}", jedis.flushAll());
    }

}
