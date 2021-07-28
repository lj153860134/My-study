package com.lingjian.controller;

import com.lingjian.domain.Account;
import com.lingjian.service.IAccountService;
import com.lingjian.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @description: 账户表现层实体类
 * @author: Ling Jian
 * @date: 2020-02-26 15:55
 **/
@Controller("accountController")
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层findAll()方法执行");

        //调用service的方法
       List<Account> list=accountService.findAll();
        model.addAttribute("list", list);
        return "list";
    }
}
