package com.lingjian.service;

import com.lingjian.domain.Account;

/**
 * @description: 账户的业务层接口
 * @author: Ling Jian
 * @date: 2020-02-17 22:05
 **/
public interface IAccountService {
    /**
     * 根据id查询账户
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 转账
     * @param sourceName
     * @param targetName
     * @param money
     */
    void transfer(String sourceName, String targetName, Float money);
}
