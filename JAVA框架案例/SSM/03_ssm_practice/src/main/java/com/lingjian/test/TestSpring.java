package com.lingjian.test;

import com.lingjian.service.IAccountService;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: spring框架的测试类
 * @author: Ling Jian
 * @date: 2020-05-25 09:54
 **/
public class TestSpring {

    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        accountService.findAllAccount();
    }
}
