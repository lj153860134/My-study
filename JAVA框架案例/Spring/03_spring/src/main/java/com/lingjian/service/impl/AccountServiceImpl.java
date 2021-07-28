package com.lingjian.service.impl;

import com.lingjian.dao.IAccountDao;
import com.lingjian.dao.impl.AccountDaoImpl;
import com.lingjian.service.IAccountService;


/**
 * @description: 账户业务层实现类
 * @author: Ling Jian
 * @date: 2020-02-10 11:04
 **/
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao=new AccountDaoImpl();

    public AccountServiceImpl() {
        System.out.println("业务层对象创建");
    }

    public void saveAccount(){

        accountDao.saveAccount();

    }
}
