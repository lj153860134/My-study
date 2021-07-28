package com.lingjian.service.impl;

import com.lingjian.dao.IAccountDao;
import com.lingjian.dao.impl.AccountDaoImpl;
import com.lingjian.factory.BeanFactory;
import com.lingjian.service.IAccountService;


/**
 * @description: 账户业务层实现类
 * @author: Ling Jian
 * @date: 2020-02-10 11:04
 **/
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao=(IAccountDao) BeanFactory.getBean("accountDao");
       private int i=1;

    public void saveAccount(){
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
