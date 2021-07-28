package com.lingjian_9;

import com.mchange.v2.c3p0.DataSources;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @description: 测试DBCP数据库连接池
 * @author: Ling Jian
 * @date: 2019-12-17 21:12
 **/
public class DBCPTest {
    //方式1 不推荐
    @Test
    public void testGetConnection() throws Exception{
        //创建DBCP的数据库连接池
        BasicDataSource source=new BasicDataSource();

        //设置基本信息
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/test");
        source.setUsername("root");
        source.setPassword("lj210910");

        //设置其他设计数据库连接池管理的相关属性
        source.setInitialSize(10);
        source.setMaxActive(10);


        Connection conn = source.getConnection();
        System.out.println(conn);

    }

    //方式2 使用配置文件
    @Test
    public void testGetConnection1()throws Exception{
        Properties pros=new Properties();
        //方式1
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        //方式2
        InputStream is=new FileInputStream(new File("src/dbcp.properties"));
        pros.load(is);
        DataSource source = BasicDataSourceFactory.createDataSource(pros);
        Connection conn = source.getConnection();
        System.out.println(conn);


    }

}
