package com.lingjian.controller;

import com.lingjian.domain.Account;
import com.lingjian.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description: 账户的表现层
 * @author: Ling Jian
 * @date: 2020-05-25 09:44
 **/
@Controller("accountController")
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/findAllAccount")
    public String findAllAccount(Model model){
        System.out.println("表现层 查询了所有账户");
        List<Account> list = accountService.findAllAccount();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping("/save")
    public void saveAccount(Account account, HttpServletRequest request, HttpServletResponse response) throws Exception {
        accountService.saveAccount(account);
        System.out.println(request.getContextPath());
        response.sendRedirect(request.getContextPath() + "/account/findAllAccount");
        return;
    }
}
