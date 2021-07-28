package com.lingjian_1.test;


import com.lingjian_1.dao.IUserDao;
import com.lingjian_1.domain.User;
import com.lingjian_1.mybatis.io.Resources;
import com.lingjian_1.mybatis.sqlsession.SqlSession;
import com.lingjian_1.mybatis.sqlsession.SqlSessionFactory;
import com.lingjian_1.mybatis.sqlsession.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @description: mybatis入门案例测试类
 * @author: Ling Jian
 * @date: 2020-01-07 09:57
 **/
public class MybatisTest {

    private InputStream is;
    private SqlSession session;
    private IUserDao userDao;

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
        //使用SqlSession创建Dao接口的代理对象
        userDao = session.getMapper(IUserDao.class);

    }

    @After //用于测试方法执行之后执行
    public void destroy(){
        //释放资源
        try {
            session.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testFindAll()  {

        //使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }


}
