package com.lingjian.dao.impl;

import com.lingjian.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @description: 账户持久层实现类
 * @author: Ling Jian
 * @date: 2020-02-10 11:14
 **/
@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {


    @Override
    public void saveAccount() {
        System.out.println("保存了账户2");
    }
}
