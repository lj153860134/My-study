package com.lingjian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 用户的表现层
 * @author: Ling Jian
 * @date: 2020-02-24 17:22
 **/
@Controller("useController")
@RequestMapping("/user")
public class UserController {

    @RequestMapping("testInterceptor")
    public String testInterceptor(){
        System.out.println("testInterceptor方法执行了");
        return "success";

    }
}
