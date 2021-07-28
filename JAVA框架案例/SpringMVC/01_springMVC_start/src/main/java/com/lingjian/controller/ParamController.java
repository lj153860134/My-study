package com.lingjian.controller;

import com.lingjian.domain.Account;
import com.lingjian.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.java2d.pipe.SpanIterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @description: 请求参数绑定
 * @author: Ling Jian
 * @date: 2020-02-22 11:18
 **/
@Controller("paramController")
@RequestMapping("/param")
public class ParamController {
    /**
     * 请求参数绑定入门
     * @param username
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username){
        System.out.println(username+" 执行了参数绑定");
        System.out.println("用户名："+username);
        return "success";
    }

    /**
     * 请求参数绑定 把数据分装到JavaBean的类中
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("执行了saveAccout");
        System.out.println(account);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveAccount(User user){
        System.out.println("执行了saveUser");
        System.out.println(user);
        return "success";
    }

    /**
     * 原生的API
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了testServlet");
        System.out.println(request);

        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);
        return "success";
    }
}
