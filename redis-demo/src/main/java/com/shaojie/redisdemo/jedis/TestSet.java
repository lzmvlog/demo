package com.shaojie.redisdemo.jedis;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author： ShaoJie
 * @data： 2020年02月01日 18:17
 * @Description： 使用 jedis 操作 set 集合 元素不能重复
 */
@Slf4j
public class TestSet {

    @Test
    public void testSet() {
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
        // log.info("添加数据 元素不能重复 sadd --- {}", jedis.sadd("key1", "value1", "value2", "value3"));
        // 删除一个数据
        // log.info("删除一个数据 srem --- {}", jedis.srem("key1", "value1"));
        // srem 也可以删除多个多个值
        // log.info("删除一个数据 srem --- {}", jedis.srem("key1", "value1","value2"));
        // 查看 set 集合中的元素 取值 类似出栈
        log.info("查看 set 集合中的元素 smembers --- {}", jedis.smembers("key1"));
        // 删除随机数值 返回具体被删除的值
        // log.info("删除随机数值 spop --- {}", jedis.spop("key1"));
        // 获取 set 集合中的个数 返回具体的个数
        log.info("获取 set 集合中的个数 返回具体的个数 scard --- {}", jedis.scard("key1"));
        // 查看 value 是否存在 当前的 key 中 存在返回 true 否则返回 false
        log.info("查看 value 是否存在 当前的 key 中 sismember --- {}", jedis.sismember("key1", "value2"));
        // 移动数据 移动过后的值 将不会存在于原 key 中
        log.info("移动数据 smove --- {}", jedis.smove("key1", "key2", "value3"));

        // 集合运算
        // 求多个集合的交集 参数为 多个 key
        log.info("求多个集合的交集 sinter --- {}", jedis.sinter("key1", "key2"));
        // 求多个集合的并集 参数为 多个 key
        log.info("求多个集合的并集 sunion --- {}", jedis.sunion("key1", "key2"));
        // 求多个集合的差集 参数为 多个 key 第一个集合中存在 二第二个集合中不存在
        log.info("求多个集合的差集 sinter --- {}", jedis.sdiff("key1", "key2"));
    }

}
