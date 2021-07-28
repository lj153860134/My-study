package com.lingjian.controller;

import com.lingjian.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @description: 常用的注解
 * @author: Ling Jian
 * @date: 2020-02-22 16:53
 **/
@Controller("annoController")
@RequestMapping("/anno")
@SessionAttributes(value={"msg"}) //把msg=美美存入session域对中
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("name") String username){
        System.out.println("执行了testRequestParam");
        System.out.println(username);
        return "success";
    }

    /**
     * 获取请求体内容
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了testRequestBody");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable注解
     * @return
     */
    @RequestMapping("/testPathVariable/{uid}")
    public String testPathVariable(@PathVariable(name="uid") String id){
        System.out.println("执行了testPathVariable");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头的值
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept") String header){
        System.out.println("执行了testRequestHeader");
        System.out.println(header);
        return "success";
    }

    /**
     * 获取Cookie的值
     * @param cookieValue
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookieValue){
        System.out.println("执行了testCookieValue");
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * ModelAttribute注解
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("执行了testModelAttribute");
        System.out.println(user);
        return "success";
    }

    /*@ModelAttribute
    public User showUser(String name) {
        System.out.println("showUser执行了");
        User user = new User();
        user.setName(name);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }*/

    @ModelAttribute
    public void showUser(String name, Map<String,User> map) {
        System.out.println("showUser执行了");
        User user = new User();
        user.setName(name);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc", user);
    }

    /**
     * SessionAttribute的注解
     * @return
     */
    @RequestMapping("/testSessionAttribute")
    public String testSessionAttribute(Model model){
        System.out.println("执行了testSessionAttribute");
        //底层会存储到request域对象中
        model.addAttribute("msg","凌健");
        return "success";
    }

    @RequestMapping("/getSessionAttribute")
    public String getSessionAttribute(ModelMap modelMap){
        System.out.println("执行了getSessionAttribute");
        String msg=(String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }
}
