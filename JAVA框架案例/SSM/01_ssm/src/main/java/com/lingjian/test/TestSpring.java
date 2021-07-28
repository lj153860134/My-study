package com.lingjian.test;

import com.lingjian.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 测试Spring
 * @author: Ling Jian
 * @date: 2020-02-26 16:18
 **/
public class TestSpring {
    @Test
    public void testSpring(){
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        //获取对象
        AccountServiceImpl as = (AccountServiceImpl)ac.getBean("accountService");

        //调用方法
        as.findAll();

    }
}
