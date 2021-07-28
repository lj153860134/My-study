package com.lingjian.service;

import com.lingjian.domain.Account;

import java.util.List;

/**
 * @description: 账户的业务层接口
 * @author: Ling Jian
 * @date: 2020-02-11 16:32
 **/

public interface IAccountService {

    /**
     * 查询所有账户信息
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询账户信息
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 保存账户信息
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新账户信息
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除账户信息
     * @param id
     */
    void deleteAccount(Integer id);
}
