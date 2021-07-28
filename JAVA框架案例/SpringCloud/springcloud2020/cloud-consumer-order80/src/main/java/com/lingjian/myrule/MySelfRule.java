package com.lingjian.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 负载均衡 自定义均衡算法类
 * @author: Ling Jian
 * @date: 2020-04-02 11:10
 **/
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){

        return new RandomRule();  //定义为随机
    }
}
