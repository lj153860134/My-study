package com.lingjian.dao;

import com.lingjian.domain.Account;

import java.util.List;

/**
 * @description: 账户的持久层接口
 * @author: Ling Jian
 * @date: 2020-02-11 16:50
 **/
public interface IAccountDao {
    /**
     * 查询所有账户信息
     *
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询账户信息
     *
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 保存账户信息
     *
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新账户信息
     *
     * @param account
     */
    void updateAccount(Account account);


    /**
     * 删除账户信息
     *
     * @param id
     */
    void deleteAccount(Integer id);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return 如果有唯一结果就返回 如果没有就返回null
     *         如果结果集中超过一个 就报异常
     */
    Account findAccountByName(String accountName);

}
