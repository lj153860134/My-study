package com.lingjian.service;

import com.lingjian.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @description: 书的业务层
 * @author: Ling Jian
 * @date: 2020-03-26 21:11
 **/

@Service
public class BookService {
    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book){
        System.out.println("收到消息"+book);
    }

    @RabbitListener(queues = "atguigu")
    public void receive1(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
