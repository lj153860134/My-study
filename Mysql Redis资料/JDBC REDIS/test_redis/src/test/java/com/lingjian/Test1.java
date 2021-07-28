package com.lingjian;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-03-07 16:19
 **/
public class Test1 {

    @Test
    public void test1() {
        //设置ip地址和端口号
        String host = "127.0.0.1";
        int port = 6379;
        Jedis jedis = new Jedis(host, port);
        //保存数据
        jedis.set("age", "18");
        //获取数据
        String age = jedis.get("age");
        String name = jedis.get("name");
        System.out.println(age + ":" + name);

        //释放资源
        jedis.close();

    }

    @Test
    public void test2() {
        //获得连接池的配置对象
        JedisPoolConfig config=new JedisPoolConfig();

        //设置最大连接池
        config.setMaxTotal(30);

        //设置最大空闲连接数
        config.setMaxIdle(10);

        //获得连接池
        JedisPool jedisPool = new JedisPool(config, "127.0.0.1", 6379);

        Jedis jedis=null;
        try {
            //获得核心对象
             jedis=jedisPool.getResource();
            //保存数据
            jedis.set("凌健","徐小萌");
            //获取数据
            String value= jedis.get("凌健");
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if(jedis!=null) {
                jedis.close();
            }
            if(jedisPool!=null){
                jedisPool.close();
            }
        }


    }

}
