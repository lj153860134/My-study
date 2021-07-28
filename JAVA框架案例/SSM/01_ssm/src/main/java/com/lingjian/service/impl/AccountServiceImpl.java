package com.lingjian.service.impl;

import com.lingjian.dao.IAccountDao;
import com.lingjian.domain.Account;
import com.lingjian.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 账户业务层实现类
 * @author: Ling Jian
 * @date: 2020-02-26 15:52
 **/
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层findAll()方法执行");
        return accountDao.findAll();

    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层saveAccount()方法执行"+account);
        accountDao.saveAccount(account);
    }
}
