package com.lingjian.dao;

import com.lingjian.domain.Account;

/**
 * @description: 账户的持久层接口
 * @author: Ling Jian
 * @date: 2020-02-16 17:16
 **/
public interface IAccountDao {
    /**
     * 根据Id查询账户
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);

    /**
     * 更新账户
     * @param account
     */
    void update(Account account);
}
