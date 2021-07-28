package com.lingjian.spring_boot;

import com.lingjian.spring_boot.Bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringBoot02QuickStartApplicationTests {

    @Autowired
    Person person;


    //自动得到Spring的容器对象
    @Autowired
    ApplicationContext ioc;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test
    public void testHelloService() {
        System.out.println(ioc.containsBean("helloService"));
    }


}
