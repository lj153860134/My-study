package com.lingjian.service;

import com.lingjian.domain.Account;

import java.util.List;

/**
 * @description: 账户的业务层接口
 * @author: Ling Jian
 * @date: 2020-05-25 09:40
 **/
public interface IAccountService {

    //查询所有账户信息
    List<Account> findAllAccount();

    //保存账户信息
    void saveAccount(Account account);
}
