package com.lingjian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 表现层
 * @author: Ling Jian
 * @date: 2020-03-17 09:24
 **/
@Controller("helloController")
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "凌健❤️徐小萌";
    }
}
