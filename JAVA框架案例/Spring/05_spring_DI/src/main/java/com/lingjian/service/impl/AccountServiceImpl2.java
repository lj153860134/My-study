package com.lingjian.service.impl;

import com.lingjian.service.IAccountService;

import java.util.Date;


/**
 * @description: 账户业务层实现类
 * @author: Ling Jian
 * @date: 2020-02-10 11:04
 **/
public class AccountServiceImpl2 implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了  "+name+age+birthday);

    }


}