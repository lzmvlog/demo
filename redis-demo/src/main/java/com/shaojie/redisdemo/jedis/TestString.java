package com.shaojie.redisdemo.jedis;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author： ShaoJie
 * @data： 2020年01月31日 17:25
 * @Description： 使用 jedis 操作 String
 */
@Slf4j
public class TestString {

    @Test
    public void testString() {
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
        // 新增数据
        // log.info("新增数据 --- {}", jedis.set("key1", "value1"));
        // log.info("新增数据 --- {}", jedis.set("key2", "value2"));
        // log.info("新增数据 --- {}", jedis.set("key3", "value3"));
        // 删除数据
        // log.info("删除数据 --- {}", jedis.del("key2"));
        // 获取数据
        // log.info("获取数据 --- {}", jedis.get("key3"));
        // 修改数据
        // log.info("修改数据 --- {}", jedis.set("key3", "value4"));
        // 追加值
        // log.info("追加值 --- {}", jedis.append("key3", "append"));
        // 增加多个值
        //log.info("增加多个值 --- {}", jedis.mset("key01", "value01", "key02", "value02"));
        // 获取多个值 返回具体的值
        // log.info("获取多个值 --- {}", jedis.mget("key01", "key02"));
        // 删除多个值
        // log.info("删除多个值 --- {}", jedis.del("key01", "key02"));

        // 新增键值对 防止覆盖原先的值 和 set 区分开来
        // log.info("新增键值对 防止覆盖原先的值 和 set 区分开来 --- {}", jedis.setnx("key1", "value1"));
        // log.info("新增键值对 防止覆盖原先的值 和 set 区分开来 --- {}", jedis.setnx("key2", "value2"));

        // 设置键值对 设置过期时间
        // log.info("设置键值对 设置过期时间 --- {}", jedis.setex("key1", 10, "value1"));
        // try {
        //     Thread.sleep(3000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // log.info("获取数据 --- {}", jedis.get("key1"));
        // 获取原来的值 更新为新值
        // log.info("获取原来的值 更新为新值 --- {}", jedis.getSet("key1", "value01"));
        // 截取指定的字符串
        log.info("截取指定的字符串 --- {}", jedis.getrange("key1",0,4));
    }
}
