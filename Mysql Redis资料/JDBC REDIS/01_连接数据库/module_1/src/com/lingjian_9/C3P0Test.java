package com.lingjian_9;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.junit.Test;

import java.sql.Connection;

/**
 * @description: C3P0连接池测试
 * @author: Ling Jian
 * @date: 2019-12-17 20:23
 **/
public class C3P0Test {
    //方式1
    @Test
    public void testGetConnection() throws Exception{
        //获取C3P0数据库连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test" );
        cpds.setUser("root");
        cpds.setPassword("lj210910");

        //通过设置相关的参数 对数据库连接池进行管理
        //设置初始时数据库连接池中的连接数
        cpds.setInitialPoolSize(10);

        Connection conn=cpds.getConnection();
        System.out.println(conn);

        //销毁C3P0数据库连接池
//        DataSources.destroy(cpds);
    }

    //方式2 使用配置文件
    @Test
    public void testGetConnection2()throws Exception{

        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }
}
