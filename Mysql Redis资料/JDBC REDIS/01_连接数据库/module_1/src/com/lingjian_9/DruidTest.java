package com.lingjian_9;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @description: 测试Druid数据库连接池
 * @author: Ling Jian
 * @date: 2019-12-17 21:53
 **/
public class DruidTest {
    @Test
    public void testGetConnection()throws Exception{
        Properties pros=new Properties();
        InputStream is=ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        pros.load(is);
        DataSource source = DruidDataSourceFactory.createDataSource(pros);
        Connection conn= source.getConnection();
        System.out.println(conn);
    }
}
