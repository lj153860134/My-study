package com.lingjian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: HelloWorld程序
 * @author: Ling Jian
 * @date: 2020-03-17 09:19
 **/


@SpringBootApplication   //标志主程序
public class HelloWorld {
    public static void main(String[] args) {
        //spring应用启动起来
        SpringApplication.run(HelloWorld.class, args);
    }
}
