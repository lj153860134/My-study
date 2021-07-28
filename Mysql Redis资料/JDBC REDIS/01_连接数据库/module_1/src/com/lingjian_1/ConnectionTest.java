package com.lingjian_1;


import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author lingjian
 * @date 2019/11/27 - 3:47 下午
 */
/*
 * 测试连接数据库
 * */
public class ConnectionTest {
    //方式1
    @Test
    public void testConnection1() throws SQLException {
        //获取Driver实现类对象
        Driver driver = new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/test";
        //将用户名和密码封装在Properties
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "lj210910");
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }

    //方式2：对方式1的迭代（在程序中不出现第三方的API 使程序有更好的移植性）
    @Test
    public void testConnection2() throws Exception {

        //通过反射获取Driver实现类对象
        Class aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        //提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test";

        //将用户名和密码封装在Properties
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "lj210910");

        //获取连接
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }

    //方式3 使用DriverManager替换Driver
    @Test
    public void testConnection3() throws Exception{

        //通过反射获取Driver实现类对象
        Class aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        //提供三个连接的基本信息
        String url="jdbc:mysql://localhost:3306/test";
        String user="root";
        String password="lj210910";
        //注册驱动
        DriverManager.registerDriver(driver);

        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

    }

    //方式4 优化方式3
    @Test
    public void testConnection4() throws Exception{
        //提供三个连接的基本信息
        String url="jdbc:mysql://localhost:3306/test";
        String user="root";
        String password="lj210910";


        //加载Driver类
         Class.forName("com.mysql.jdbc.Driver");
         //可以如下的操作
//        Driver driver = (Driver) aClass.newInstance();
//
//        //注册驱动
//        DriverManager.registerDriver(driver);
        /**
         * 在mysql的Driver实现类中 声明了如下的操作
         * 静态方法随着类的加载而加载
         * 会自动注册驱动程序
         */
        /*static {
            try {
                java.sql.DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            } catch (SQLException E) {
                throw new RuntimeException("Can't register driver!");
            }
        }*/

        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

    }

    //方式5 最终版本 将连接的4个基本信息声明在配置文件中
    //     通过读取配置文件 获取连接
    /*
    *  该方式的好处
    *  1.实现数据与代码的分离 实现了解耦
    *  2.如果需要修改配置文件信息 可以避免程序重新打包
    *
    * */
    @Test
    public void testConnection5() throws Exception {

        //读取配置文件中的4个基本信息
        InputStream is=ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros=new Properties();
        pros.load(is);
        String user=pros.getProperty("user");
        String password=pros.getProperty("password");
        String url=pros.getProperty("url");
        String driverClass=pros.getProperty("driverClass");

        //加载Driver驱动并自动注册驱动
        Class.forName(driverClass);

        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

    }
}
