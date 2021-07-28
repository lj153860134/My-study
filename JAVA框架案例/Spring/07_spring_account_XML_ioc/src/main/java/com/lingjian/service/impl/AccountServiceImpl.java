package com.lingjian.service.impl;

import com.lingjian.dao.IAccountDao;
import com.lingjian.domain.Account;
import com.lingjian.service.IAccountService;

import java.util.List;

/**
 * @description: 账户业务层的实现类
 * @author: Ling Jian
 * @date: 2020-02-11 16:48
 **/
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
       return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }
    public void updateAccount(Account account){
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }
}
