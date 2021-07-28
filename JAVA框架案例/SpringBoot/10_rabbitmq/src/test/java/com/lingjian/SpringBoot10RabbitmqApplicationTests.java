package com.lingjian;

import com.lingjian.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringBoot10RabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;



    /**
     * 单播发送消息（点对点）
     */
    @Test
    void contextLoads() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld",123,true));
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new Book("西游记","吴承恩"));
    }

    //接收数据
    @Test
    public void test1(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    //广播
    @Test
    public void test2() {
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("红楼梦","施耐庵"));
    }

    //amqpAdmin创建exchange queue binding
    @Test
    public void test3() {
        //创建exchange
//        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
        //创建queue
//        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue",true));
//        System.out.println("创建完成");
        //创建绑定规则
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE,"amqpAdmin.exchange","amqp.haha",null));
    }
}
