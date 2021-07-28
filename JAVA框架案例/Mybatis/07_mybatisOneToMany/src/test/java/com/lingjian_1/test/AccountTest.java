package com.lingjian_1.test;


import com.lingjian_1.dao.IAccountDao;
import com.lingjian_1.dao.IUserDao;
import com.lingjian_1.domain.Account;
import com.lingjian_1.domain.AccountUser;
import com.lingjian_1.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 入门案例测试类
 * @author: Ling Jian
 * @date: 2020-01-07 09:57
 **/
public class AccountTest {
    private InputStream is;
    private SqlSession session;
    private IAccountDao accountDao;

    @Before //用于测试方法执行之前执行
    public void init() throws Exception {
        //读取配置文件(两种方式)
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
//        InputStream is=MybatisTest.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        //使用工厂生产SqlSession对象
        session = factory.openSession();
//        session = factory.openSession(true);    //打开自动提交
        //使用SqlSession创建Dao接口的代理对象
        accountDao = session.getMapper(IAccountDao.class);

    }

    @After //用于测试方法执行之后执行
    public void destroy() {
        //释放资源
        try {
            session.commit();  //提交事务
            session.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有账户信息
     */
    @Test
    public void testFindAll() {

        //使用代理对象执行方法
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("-------每个account的信息------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    /**
     * 查询所有账户 同时包含用户名称和地址
     */
    @Test
    public void testFindAllAccount() {

        //使用代理对象执行方法
        List<AccountUser> accounts = accountDao.findAllAccount();
        for (AccountUser accountUser : accounts) {
            System.out.println(accountUser);
        }

    }


}
