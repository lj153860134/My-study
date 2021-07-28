package com.lingjian_1.test;

import com.lingjian_1.dao.IUserDao;
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

/**
 * @description: 二级缓存测试
 * @author: Ling Jian
 * @date: 2020-02-09 16:09
 **/
public class SecondLevelCacheTest {
    private InputStream is;
    private SqlSessionFactory factory;
    private IUserDao userDao;

    @Before //用于测试方法执行之前执行
    public void init() throws Exception {
        //读取配置文件(两种方式)
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
//        InputStream is=MybatisTest.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(is);


    }

    @After //用于测试方法执行之后执行
    public void destroy() {
        //释放资源
        try {

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFirstLevelCache(){
        SqlSession sqlSession1=factory.openSession();
        IUserDao dao1=sqlSession1.getMapper(IUserDao.class);
        User user1=dao1.findById(41);
        System.out.println(user1);
        sqlSession1.close();

        SqlSession sqlSession2=factory.openSession();
        IUserDao dao2=sqlSession2.getMapper(IUserDao.class);
        User user2=dao2.findById(41);
        System.out.println(user2);
        sqlSession2.close();

        System.out.println(user1==user2);


    }
}
