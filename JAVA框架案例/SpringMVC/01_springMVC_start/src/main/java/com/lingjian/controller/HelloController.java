package com.lingjian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description: 控制器的类
 * @author: Ling Jian
 * @date: 2020-02-21 10:19
 **/
@Controller("helloController")
@RequestMapping(path = "/user")
public class HelloController {

    /**
     * 入门案例
     * @return
     */
    @RequestMapping(value="/hello")
    public String sayHello(){
        System.out.println("hello SpringMVC");
        return "success";
    }

    /**
     * RequestMapping注解
     * @return
     */
    @RequestMapping(value = "/testRequestMapping",params = {"username"},headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("测试RequestMapping");
        return "success";
    }
}
