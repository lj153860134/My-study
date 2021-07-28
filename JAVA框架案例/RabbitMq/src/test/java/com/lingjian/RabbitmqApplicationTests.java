package com.lingjian;

import com.rabbitmq.client.*;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class RabbitmqApplicationTests {
    @Autowired
    AmqpAdmin amqpAdmin;






    //rabbitmq生产者
    @Test
    void providerTest() throws Exception{
        //创建一个connectionFactory 并进行配置
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername("lingjian");
        connectionFactory.setPassword("lj210910");
        connectionFactory.setHost("192.168.0.129");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");

        //通过连接工厂创建连接
        Connection connection = connectionFactory.newConnection();

        //通过connection创建一个channel
        Channel channel = connection.createChannel();

        //声明交换机  参数一：交换机的名字  参数二：交换机的类型
        channel.exchangeDeclare("exchange_fanout", BuiltinExchangeType.FANOUT);

        //声明队列
        /**
         * @param queue 队列的名称
         * @param durable 如果我们声明一个持久队列，则为true（队列将在服务器重启后继续存在）
         * @param exclusive 如果我们声明一个独占队列（仅限于此连接），则为true
         * @param autoDelete 如果我们声明一个自动删除队列，则为true（服务器将在不再使用时将其删除）
         * @param arguments 队列的其他属性（构造参数）
         */
        channel.queueDeclare("test1", true, false, false, null);
        channel.queueDeclare("test2", true, false, false, null);

        // 绑定队列
        // 参数一：队列名称
        // 参数二：交换机名称
        // 参数三：路由键，因为使用的交换机类型是fanout，所以RouteKey为空串即可
        channel.queueBind("test1", "exchange_fanout", "");
        channel.queueBind("test2", "exchange_fanout", "");

        // 参数一：交换机的名称
        // 参数二：路由键，还是一样给个空串
        // 参数三：消息的其他属性 - 路由头等。
        // 参数四：消息的内容
        String msg = "hello lingjian";
        channel.basicPublish("exchange_fanout", "", null, msg.getBytes());

        //关闭连接
        channel.close();
        connection.close();

    }


    //rabbitmq消费者
    @Test
    public void consumerTest() throws Exception{
        //创建一个connectionFactory 并进行配置
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername("lingjian");
        connectionFactory.setPassword("lj210910");
        connectionFactory.setHost("192.168.0.129");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");

        //通过连接工厂创建连接
        Connection connection = connectionFactory.newConnection();

        //通过connection创建一个channel
        Channel channel = connection.createChannel();

        //声明（创建）一个队列
        String queueName = "test1";
        channel.queueDeclare(queueName, true, false, false, null);

        //一定要创建消费者
        /** 监听了test1_queue这个队列
         * @param queue 队列的名称
         * @param autoAck 是否自动回复
         * @param callback 消费者对象的接口
         */
        channel.basicConsume(queueName, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费端"+new String(body,"UTF-8"));
            }


        });





    }

    //amqpAdmin创建exchange queue binding
    @Test
    public void test3() {
        //创建exchange
        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
        //创建queue
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue",true));
//        System.out.println("创建完成");
        //创建绑定规则
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE,"amqpAdmin.exchange","amqp.haha",null));
    }

}
