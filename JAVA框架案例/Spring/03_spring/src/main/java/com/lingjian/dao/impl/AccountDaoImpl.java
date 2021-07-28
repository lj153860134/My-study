package com.lingjian.dao.impl;

import com.lingjian.dao.IAccountDao;

/**
 * @description: 账户持久层实现类
 * @author: Ling Jian
 * @date: 2020-02-10 11:14
 **/
public class AccountDaoImpl implements IAccountDao {

    public AccountDaoImpl() {
        System.out.println("持久层对象创建了");
    }

    @Override
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
