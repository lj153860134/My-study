package com.lingjian.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description: 容器的配置类
 * @author: Ling Jian
 * @date: 2020-03-30 16:51
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced //赋予RestTemplate负载均衡的能力
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
