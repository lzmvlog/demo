package com.shaojie.redisdemo.jedis;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： ShaoJie
 * @data： 2020年02月01日 18:44
 * @Description： 使用 jedis 操作 hash 类型数据
 */
@Slf4j
public class TestHash {

    @Test
    public void testHash() {
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
        // 添加数据 类似列表 类似堆栈 先插入的值在最下面 第一个是key 往后的都是 value 从左侧添加
        // hmset 可以直接添加 map
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.put("key3", "value3");
        // log.info("添加数据 元素不能重复 hmset --- {}", jedis.hmset("key", hashMap));
        // 添加数据 但是只能单个添加 不能添加 map 添加的是键值对类型的 重复添加显示为 0 添加成功返回 1
        // log.info("添加数据 元素不能重复 hset --- {}", jedis.hset("key", "key4", "value4"));
        // 获取 map 中的所有数据
        log.info("获取 map 中的所有数据 hgetAll --- {}", jedis.hgetAll("key"));
        // 获取 map 中的 key
        log.info("获取 map 中的 key hkeys --- {}", jedis.hkeys("key"));
        // 获取 map 中的 value
        log.info("获取 map 中的 value hvals --- {}", jedis.hvals("key"));
        // 将这个 值递增 不存在则添加当前 key 递增当前值
        // log.info("将这个 值递增 不存在则添加当前 key 递增当前值 hincrBy --- {}", jedis.hincrBy("key","key5",5));
        // 删除一个或多个键值对
        // log.info(" 删除一个或多个键值对 hdel --- {}", jedis.hdel("key","key5"));
        // 获取 hash 的大小
        log.info("获取 hash 的大小 hlen --- {}", jedis.hlen("key"));
        // 判断某个值是否存在 存在返回 true 否则返回 false
        log.info("判断某个值是否存在 hlen --- {}", jedis.hexists("key","key5"));
        // 获取 hash 中单个的值
        log.info("获取 hash 中的值 hlen --- {}", jedis.hget("key","key1"));
        // 获取 hash 中多个的值
        log.info("获取 hash 中的值 hlen --- {}", jedis.hmget("key","key1","key2"));
    }

}
