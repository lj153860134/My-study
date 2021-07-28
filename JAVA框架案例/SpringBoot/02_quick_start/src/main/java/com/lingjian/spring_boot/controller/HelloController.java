package com.lingjian.spring_boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 表现层
 * @author: Ling Jian
 * @date: 2020-03-17 13:56
 **/

/*@ResponseBody  //这个类所有的返回数据直接写给浏览器(如果是对象转为json数据）
@Controller("helloController")*/

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "小小贱❤️徐小萌";
    }
}
