package com.lingjian.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description: 配置类
 * @author: Ling Jian
 * @date: 2020-03-31 15:58
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced  //负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
