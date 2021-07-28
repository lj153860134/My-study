package com.lingjian.factory;

import com.lingjian.service.IAccountService;
import com.lingjian.service.impl.AccountServiceImpl;

/**
 * @description: 模拟一个工厂类
 *               （该类可能是存在于jar包中 我们无法通过修改源码的方式来提供默认构造函数）
 * @author: Ling Jian
 * @date: 2020-02-10 19:21
 **/
public class InstanceFactory {

    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
