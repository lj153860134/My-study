package com.lingjian.jdbctemplate;

import com.lingjian.dao.IAccountDao;
import com.lingjian.dao.impl.AccountDaoImpl;
import com.lingjian.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @description: JdbcTemplate的最基本的用法
 * @author: Ling Jian
 * @date: 2020-02-16 16:10
 **/
public class jdbcTemplateDemo4 {
    public static void main(String[] args) {

        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
        IAccountDao accountDao=ac.getBean("accountDao", AccountDaoImpl.class);

        Account account=accountDao.findAccountById(1);
        System.out.println(account);

    }
}
