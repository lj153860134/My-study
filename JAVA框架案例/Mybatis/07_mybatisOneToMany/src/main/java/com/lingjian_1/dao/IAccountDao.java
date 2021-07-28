package com.lingjian_1.dao;

import com.lingjian_1.domain.Account;
import com.lingjian_1.domain.AccountUser;

import java.util.List;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-02-08 16:13
 **/
public interface IAccountDao {
    /**
     * 查询所有账户信息 同时还要获取当前账户的所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户信息 同时带有用户名称和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();

}
