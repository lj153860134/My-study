package com.lingjian.service;

import com.lingjian.domain.Account;

import java.util.List;

/**
 * @description: 账户业务层接口
 * @author: Ling Jian
 * @date: 2020-02-26 15:52
 **/
public interface IAccountService {
    //查询所有账户信息
    public List<Account> findAll();

    //保存用户信息
    public void saveAccount(Account account);
}
