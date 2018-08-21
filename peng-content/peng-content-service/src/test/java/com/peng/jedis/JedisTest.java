package com.peng.jedis;

import org.junit.Test;
import org.omg.CORBA.SetOverrideType;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;

public class JedisTest {

    /**
     * jedis 连接单机版
     *
     * @author renyapeng
     * @date 2018/08/20
     */
    @Test
    public void testJedis() {
        // 创建一个 jedis 对象
        Jedis jedis = new Jedis("192.168.25.135", 6379);
        // 直接使用 jedis 对象管理 redis
        jedis.set("hello", "1000");
        String string = jedis.get("hello");
        System.out.println(string);
        // 关闭 jedis
        jedis.close();
    }

    /**
     * jedisPool 连接单机版
     *
     * @author renyapeng
     * @date 2018/08/20
     */
    @Test
    public void testJedisPool() {
        // 1）创建一个 JedisPool 对象
        JedisPool jedisPool = new JedisPool("192.168.25.135", 6379);
        // 2）从连接池中获得连接，一个连接就是一个 Jedis 对象
        Jedis jedis = jedisPool.getResource();
        // 3）使用 Jedis 管理 redis
        jedis.set("hello", "100");
        String string = jedis.get("hello");
        System.out.println(string);
        // 4）使用完毕之后关闭 Jedis，让连接池回收连接
        jedis.close();
        // 5）系统结束之前关闭 JedisPool 对象，JedisPool 在系统中应该是单例的
        jedisPool.close();
    }

    /**
     * jedis 连接集群版
     *
     * @author renyapeng
     * @date 2018/08/20
     */
    @Test
    public void testJedisCluster() {
        // 1）使用 JedisCluster 对象，构造参数 nodes 是一个集合，集合中有多个 HostAndPort 对象
        HashSet<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.25.135", 7001));
        nodes.add(new HostAndPort("192.168.25.135", 7002));
        nodes.add(new HostAndPort("192.168.25.135", 7003));
        nodes.add(new HostAndPort("192.168.25.135", 7004));
        nodes.add(new HostAndPort("192.168.25.135", 7005));
        nodes.add(new HostAndPort("192.168.25.135", 7006));
        JedisCluster jedisCluster = new JedisCluster(nodes);
        // 2）使用 JedisCluster 管理集群
        jedisCluster.set("hello", "1000");
        String string = jedisCluster.get("hello");
        System.out.println(string);
        // 3）系统结束之前关闭 JedisCluster 对象
        jedisCluster.close();
    }
}
