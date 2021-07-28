package com.lingjian.dao;

import com.lingjian.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 账户持久层接口
 * @author: Ling Jian
 * @date: 2020-02-26 15:48
 **/
@Repository("accountDao")
public interface IAccountDao {

    //查询所有账户信息
    @Select("select * from account")
    public List<Account> findAll();

    //保存用户信息
    @Insert("insert into account(name,money) values(#{name},#{money})")
    public void saveAccount(Account account);

}
