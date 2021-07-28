package com.lingjian.spring_boot.config;

import com.lingjian.spring_boot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 配置类
 * @author: Ling Jian
 * @date: 2020-03-17 16:05
 **/

@Configuration
public class MyAppConfig {

    @Bean
    public HelloService helloService() {
//        System.out.println("凌健❤️徐小萌");
        return new HelloService();
    }
}
