package com.lingjian.service;

/**
 * @description: 账户的业务层接口
 * @author: Ling Jian
 * @date: 2020-02-14 15:03
 **/
public interface IAccountService {

    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户
     * @param i
     */
    void  updateAccount(int i);

    /**
     * 模拟删除账户
     * @return
     */
    int deleteAccount();
}
