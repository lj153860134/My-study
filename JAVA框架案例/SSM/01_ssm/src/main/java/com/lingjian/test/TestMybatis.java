package com.lingjian.test;

import com.lingjian.dao.IAccountDao;
import com.lingjian.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-02-26 20:46
 **/
public class TestMybatis {

    @Test
    public void testMybatisFindAll() throws Exception{
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory工厂对象
        SqlSessionFactory factory = builder.build(is);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        IAccountDao accountDao=session.getMapper(IAccountDao.class);

        //查询账户所有信息
        List<Account> accounts=accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);

        }

        //关闭资源
        session.close();
        is.close();




    }

    @Test
    public void testMybatisSaveAccount() throws Exception{
        Account account=new Account();
        account.setName("王小龙");
        account.setMoney(400d);
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory工厂对象
        SqlSessionFactory factory = builder.build(is);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        IAccountDao accountDao=session.getMapper(IAccountDao.class);

        //保存账户信息
        accountDao.saveAccount(account);

        //关闭资源
        session.commit();
        session.close();
        is.close();

    }
}
