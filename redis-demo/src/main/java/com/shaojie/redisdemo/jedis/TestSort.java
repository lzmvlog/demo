package com.shaojie.redisdemo.jedis;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.SortingParams;

/**
 * @author： ShaoJie
 * @data： 2020年02月01日 19:09
 * @Description： 使用 jedis 操作 sortset 有序集合
 */
@Slf4j
public class TestSort {

    @Test
    public void testSort() {
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
        // 添加数据 类似列表 类似堆栈 先插入的值在最下面 第一个是key 往后的都是 value 从左侧添加 类似 list 类型的添加
        // log.info("添加数据 lpush --- {}", jedis.lpush("key1", "value1", "value2", "value3"));
        // 获取数据 list 0 - -1 查看的是所有的值 像从左向右
        log.info("获取数据 lrange --- {}", jedis.lrange("key1", 0, -1));
        // 排序 初始化数据
        // log.info("添加数据 lpush --- {}", jedis.lpush("value", "2", "1", "3"));
        // 初始化一个升序或降序的参数
        SortingParams sortingParams = new SortingParams();
        log.info("排序 默认升序排列 sort --- {}", jedis.sort("value", sortingParams.asc()));
        log.info("排序 降序排列 sort --- {}", jedis.sort("value",sortingParams.desc()));
    }

}
