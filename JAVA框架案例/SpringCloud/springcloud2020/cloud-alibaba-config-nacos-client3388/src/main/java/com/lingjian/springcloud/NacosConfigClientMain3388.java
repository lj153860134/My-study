package com.lingjian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description: 主启动类
 * @author: Ling Jian
 * @date: 2020-04-07 17:24
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClientMain3388 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMain3388.class, args);
    }
}

