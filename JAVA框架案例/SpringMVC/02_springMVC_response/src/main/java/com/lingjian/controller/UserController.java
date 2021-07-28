package com.lingjian.controller;

import com.lingjian.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 用户的表现层
 * @author: Ling Jian
 * @date: 2020-02-23 09:39
 **/
@Controller("userController")
@RequestMapping("/user")
public class UserController {

    /**
     * 返回值是String
     *
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString方法执行了");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("凌健");
        user.setPassword("123456");
        user.setAge(26);
        //model对象存储数据
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 返回值是String
     * 请求转发一次请求 不应编写项目的名称
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid方法执行了");
        //编写请求转发的程序
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
//        response.sendRedirect(request.getContextPath() + "/index.jsp");

        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //直接回进行响应
        response.getWriter().print("凌健爱徐小萌");
        return;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView方法执行了");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("凌健");
        user.setPassword("123456");
        user.setAge(26);

        //把User对象存储到mv对象中 也会吧user对象存入到request对象中
        mv.addObject("user", user);

        //跳转到哪个页面
        mv.setViewName("success");
        return mv;
    }

    /**
     * 模拟异步请求响应
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax方法执行");
        //客户端发送ajax的请求 传的是json字符串 后端把json字符串封装到user对象
        System.out.println(user);
        //做响应 模拟查询数据库
        user.setUsername("凌健");
        user.setAge(18);
        System.out.println(user);
        return user;
    }


}
