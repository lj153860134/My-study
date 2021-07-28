package com.lingjian.dao.impl;

import com.lingjian.dao.IAccountDao;
import com.lingjian.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @description: 账户持久层实现类
 * @author: Ling Jian
 * @date: 2020-02-16 17:19
 **/

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {


    @Override
    public Account findAccountById(Integer id) {
        List<Account> accounts= super.getJdbcTemplate().query("select * from account where id=?",new BeanPropertyRowMapper(Account.class),id);
        return accounts.isEmpty() ? null : accounts.get(0);

    }

    @Override
    public Account findAccountByName(String accountName) {
        List<Account> accounts= super.getJdbcTemplate().query("select * from account where name=?",new BeanPropertyRowMapper(Account.class),accountName);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    @Override
    public void update(Account account) {
        super.getJdbcTemplate().update("update account set money=? where name=?",account.getMoney(),account.getName());
    }
}
