package com.peng.jedis;

import com.peng.common.jedis.JedisClient;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JedisClientTest {

    @Test
    public void testJedisClient() {
        // 创建一个 spring 容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
        // 从容器中获得 JedisClient 对象
        JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
        // 使用 JedisClient 管理 redis
        String string = jedisClient.get("hello");
        System.out.println(string);
    }
}
