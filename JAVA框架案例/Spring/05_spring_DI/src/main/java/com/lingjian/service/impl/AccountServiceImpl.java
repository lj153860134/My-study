package com.lingjian.service.impl;

import com.lingjian.service.IAccountService;

import java.util.Date;


/**
 * @description: 账户业务层实现类
 * @author: Ling Jian
 * @date: 2020-02-10 11:04
 **/
public class AccountServiceImpl implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age,Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday=birthday;

    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了  "+name+age+birthday);

    }

}