package com.lingjian.service.impl;

import com.lingjian.service.IAccountService;


/**
 * @description: 账户业务层实现类
 * @author: Ling Jian
 * @date: 2020-02-10 11:04
 **/
public class AccountServiceImpl implements IAccountService {


    public AccountServiceImpl() {
        System.out.println("业务层对象创建");
    }

    public void saveAccount(){
        System.out.println("service中的saveAccount方法执行了");

    }

    public void init(){
        System.out.println("对象初始化了");
    }

    public void destroy(){
        System.out.println("对象销毁了");
    }
}
