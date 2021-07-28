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
 * @description: 测试mybatis
 * @author: Ling Jian
 * @date: 2020-05-25 16:41
 **/
public class TestMybatis {
    @Test
    public void test() throws Exception{
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession();
        IAccountDao accountDao = session.getMapper(IAccountDao.class);
        List<Account> list = accountDao.findAllAccount();
        for (Account account : list) {
            System.out.println(account);
        }

        session.close();
        is.close();
    }
}
