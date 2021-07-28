package com.lingjian.service.impl;

import com.lingjian.dao.IAccountDao;
import com.lingjian.domain.Account;
import com.lingjian.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 账户业务层接口的实现类
 * @author: Ling Jian
 * @date: 2020-05-25 09:40
 **/
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> findAllAccount() {
        System.out.println("业务层 查询了所有账户");
        return accountDao.findAllAccount();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层 保存了账户: "+account);
        accountDao.saveAccount(account);
    }
}
