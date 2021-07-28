package com.lingjian.service.impl;

import com.lingjian.dao.IAccountDao;
import com.lingjian.domain.Account;
import com.lingjian.service.IAccountService;

/**
 * @description: 账户业务层的实现类
 * 事务控制应该都是在业务层
 * @author: Ling Jian
 * @date: 2020-02-11 16:48
 **/
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;


    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);

    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {

        System.out.println("transfer start ");
        //执行操作
        //根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //转出账户减钱
        source.setMoney(source.getMoney() - money);
        //转入账户加钱
        target.setMoney(target.getMoney() + money);
        //更新转出账户
        accountDao.updateAccount(source);
        //模拟异常
//            int i=1/0;
        //更新转入账户
        accountDao.updateAccount(target);


    }
}
