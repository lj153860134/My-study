package com.lingjian.dao;

import com.lingjian.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 账户持久层的接口
 * @author: Ling Jian
 * @date: 2020-05-25 09:37
 **/
//@Repository("accountDao")
public interface IAccountDao {

    //查询所有账户信息
    @Select("select * from account")
    List<Account> findAllAccount();

    //保存账户信息
    @Insert("insert into account(name,money) values(#{name},#{money})")
    void saveAccount(Account account);
}
