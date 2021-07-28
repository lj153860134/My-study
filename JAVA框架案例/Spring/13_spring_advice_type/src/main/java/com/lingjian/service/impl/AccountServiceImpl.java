package com.lingjian.service.impl;

import com.lingjian.service.IAccountService;

/**
 * @description: 账户业务层的实现类
 * @author: Ling Jian
 * @date: 2020-02-14 15:07
 **/
public class AccountServiceImpl implements IAccountService {

    @Override
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("执行了更新 "+i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
