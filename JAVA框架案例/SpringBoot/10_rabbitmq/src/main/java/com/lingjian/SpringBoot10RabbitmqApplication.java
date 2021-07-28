package com.lingjian;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit //开启数值解的RabbitMQ
@SpringBootApplication
public class SpringBoot10RabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot10RabbitmqApplication.class, args);
    }

}
