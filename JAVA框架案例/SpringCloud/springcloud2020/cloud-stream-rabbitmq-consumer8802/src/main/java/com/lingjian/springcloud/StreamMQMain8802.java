package com.lingjian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description: 主启动类 8802
 * @author: Ling Jian
 * @date: 2020-04-06 19:19
 **/
@SpringBootApplication
@EnableEurekaClient
public class StreamMQMain8802{

    public static void main(String[] args) {

        SpringApplication.run(StreamMQMain8802.class,args);
    }
}
