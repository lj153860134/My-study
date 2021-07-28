package com.lingjian.controller;

import com.lingjian.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 用户的表现层
 * @author: Ling Jian
 * @date: 2020-02-24 16:08
 **/
@Controller("userController")
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("testException方法执行了");

        try {
            //模拟异常
            int a=1/0;
        } catch (Exception e) {
            //控制台打印异常信息
            e.printStackTrace();
            //跑出自定义异常信息
            throw new SysException("查询所有用户出现错误");
        }
        return "success";
    }
}
