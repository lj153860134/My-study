package com.lingjian.helloworld_quick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 表现层
 * @author: Ling Jian
 * @date: 2020-06-22 10:29
 **/
//@Controller
//@ResponseBody
    @RestController
public class HelloController {

//    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World Quick";
    }
}
