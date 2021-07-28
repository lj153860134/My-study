package com.lingjian.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @description: 自定义实现事件监听器
 * @author: Ling Jian
 * @date: 2020-03-23 14:06
 **/
public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ConfigurableApplicationContext....启动啦"+applicationContext);
    }
}
