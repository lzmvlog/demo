package com.shaojie.redisdemo.jedis;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

/**
 * @author： ShaoJie
 * @data： 2020年01月30日 16:52
 * @Description： 使用 jedis 连接 redis
 *                redis 类型：
 *                        string
 *                        list
 *                        hash
 *                        set
 *                        sortedSet
 */
@Slf4j
public class TestJedis {

    public static void main(String[] args) {
        @Cleanup Jedis jedis = new Jedis("120.78.189.213", 6379);
        // 如果设置密码 则需要设置密码
        jedis.auth("123456");
        // String
        jedis.set("name","zhangsan");
        log.info("name: {}",jedis.get("name"));
    }

}
