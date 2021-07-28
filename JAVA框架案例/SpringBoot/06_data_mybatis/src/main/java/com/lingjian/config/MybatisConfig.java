package com.lingjian.config;


import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.stereotype.Component;

/**
 * @description: Mybatis的配置类
 * @author: Ling Jian
 * @date: 2020-03-22 19:50
 **/

@org.springframework.context.annotation.Configuration
public class MybatisConfig implements ConfigurationCustomizer{
    @Override
    public void customize(Configuration configuration) {
        configuration.setMapUnderscoreToCamelCase(true);
    }
}
