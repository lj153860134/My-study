package com.lingjian.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: Feign的配置类
 * @author: Ling Jian
 * @date: 2020-04-02 16:35
 **/
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){

        return Logger.Level.FULL;
    }
}
