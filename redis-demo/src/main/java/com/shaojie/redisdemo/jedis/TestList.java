package com.shaojie.redisdemo.jedis;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author： ShaoJie
 * @data： 2020年01月31日 19:09
 * @Description： 使用 jedis 操作 list 列表
 */
@Slf4j
public class TestList {

    @Test
    public void testList() {
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
        // 添加数据 list 单个也行 多个也行 第一个是key 往后的都是 value 从左侧添加
        // log.info("添加数据 lpush --- {}", jedis.lpush("key1", "value1", "value2", "value3"));
        // log.info("添加数据 list --- {}", jedis.lpush("key1", "value1"));
        // log.info("添加数据 list --- {}", jedis.lpush("key2", "value2"));
        // log.info("添加数据 list --- {}", jedis.lpush("key3", "value3"));
        // 获取数据 list 0 - -1 查看的是所有的值 像从左向右
        log.info("获取数据 lrange --- {}", jedis.lrange("key1", 0, -1));
        // 删除列表指定的数据 第二个参数为删除的个数 当有重复的值时 先添加的值 被先删除 类型出栈 第二个参数指定删除几个 第三个参数指定删除哪一个 value
        // log.info("获取数据 lrem --- {}", jedis.lrem("key1", 1, "value2"));
        // 删除区间以外的值
        // log.info("删除区间以外的值 ltrim --- {}", jedis.ltrim("key1", 0, 3));
        // 出栈 去除一个数据 从左侧出来 也就是 列表最后插入的值 也可以说是第一个值 lpop
        // log.info("出栈 去除一个数据  lpop --- {}", jedis.lpop("key1"));
        // 添加数据 从右侧添加
        // log.info("添加数据 从右侧添加 rpush --- {}", jedis.rpush("key1", "value01", "value02", "value03"));
        // 出栈 去除一个数据 从左侧出来 也就是 列表最先插入的值 也可以说是第一个值 lpop
        // log.info("出栈 去除一个数据 rpop --- {}", jedis.rpop("key1"));
        // 指定修改下标为 1 的内容
        // log.info("指定修改下标为 1 的内容 --- {}", jedis.lset("key1",1,"newValue02"));
        // 获取集合元素长度
        // log.info("获取集合元素长度 --- {}", jedis.llen("key1"));
        // 获取指定下标的值
        // log.info("获取指定下标的值 --- {}", jedis.lindex("key1",1));

        // 排序 初始化数据
        // log.info("添加数据 lpush --- {}", jedis.lpush("value", "2", "1", "3"));
        // log.info("排序 默认升序排列 sort --- {}", jedis.sort("value"));

    }

}
