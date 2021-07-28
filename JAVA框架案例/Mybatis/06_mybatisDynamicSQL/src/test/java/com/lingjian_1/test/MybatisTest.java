package com.lingjian_1.test;


import com.lingjian_1.dao.IUserDao;
import com.lingjian_1.domain.QueryVo;
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
import java.util.Date;
import java.util.List;

/**
 * @description: 入门案例测试类
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
//        session = factory.openSession(true);    //打开自动提交
        //使用SqlSession创建Dao接口的代理对象
        userDao = session.getMapper(IUserDao.class);

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


    @Test
    public void testFindAll() {

        //使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }


    /**
    * @description: 查询一个用户对象
    * @param: []
    * @return: void
    * @author: Ling Jian
    * @date: 2020/2/5 3:42 下午
    */
    @Test
    public void testFindById(){
        User user=userDao.findById(50);
        System.out.println(user);
    }

    /**
    * @description: 根据name模糊查询
    * @param: []
    * @return: void
    * @author: Ling Jian
    * @date: 2020/2/5 4:00 下午
    */
    @Test
    public void testFindByName(){
        List<User> users=userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }

    }

    /**
    * @description: 查询所有用户数目
    * @param: []
    * @return: void
    * @author: Ling Jian
    * @date: 2020/2/5 5:17 下午
    */
    @Test
    public void testFindCount(){
        int result=userDao.findCount();
        System.out.println("总的用户数为 "+result);
    }

    /**
    * @description: 测试使用QueryVo作为查询条件
    * @param: []
    * @return: void
    * @author: Ling Jian
    * @date: 2020/2/5 5:18 下午
    */
    /*@Test
     *//*public void testFindUserByVo(){
        QueryVo vo=new QueryVo();
        User user=new User();
        user.setUsername("%王%");
        vo.setUser(user);

        List<User> users=userDao.findUserByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }

    }*/

    /**
     * 根据条件查询用户
     */
    @Test
    public void testFindUserByCondition() {
        User u = new User();
        u.setUserName("凌健");
        u.setUserSex("男");
        //使用代理对象执行方法
        List<User> users = userDao.findUserByCondition(u);
        for (User user : users) {
            System.out.println(user);
        }

    }

    /**
     * 根据queryVo中提供的id集合 查询用户信息
     * 并测试foreach标签使用
     */
    @Test
    public void testFindUserInIds() {
        List<Integer> list=new ArrayList<>();
        list.add(41);
        list.add(50);
        list.add(57);
        QueryVo vo=new QueryVo();
        vo.setIds(list);
        //使用代理对象执行方法
        List<User> users = userDao.findUserInIds(vo);
        for (User user : users) {
            System.out.println(user);
        }

    }
}
