package com.lingjian.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-03-23 14:54
 **/
@Configuration
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnWebApplication  //web应用生效

public class HelloServiceAutoConfiguration {
    @Autowired
    HelloProperties helloProperties;

    @Bean
    public HelloService helloService() {
        HelloService service=new HelloService();
        service.setHelloProperties(helloProperties);
        return service;
    }
}
