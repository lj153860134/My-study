package com.lingjian_3;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author lingjian
 * @description 操作数据库的工具类
 * @date 2019/12/3 - 8:10 下午
 */
public class JDCBUtils {
    /**
     * @description: 获取数据库的连接
     * @param: []
     * @return: java.sql.Connection
     * @author: lingjian
     * @date: 2019/12/3 9:04 下午
     */
    public static Connection getConnection()  throws Exception{
        //读取配置文件中的4个基本信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        is.close();
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //加载和注册Driver驱动
        Class.forName(driverClass);

        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
//        System.out.println(conn);
        return conn;
    }

    /*
    * 使用C3P0数据库连接池技术
    * */

    //数据库连接池只需要提供一个
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
    //使用连接池C3P0获取连接
    public static Connection getConnection1()throws Exception{
        Connection conn = cpds.getConnection();
        return conn;
    }

    /*
     * 使用Dbcp数据库连接池技术
     * */
    private static DataSource source;
    static {
        try {
            //方式1
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
            //方式2
            Properties pros=new Properties();
            InputStream is=new FileInputStream(new File("src/dbcp.properties"));
            pros.load(is);
           source = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        public static Connection getConnection2()throws Exception{

        Connection conn = source.getConnection();
        return conn;
    }

    /*
     * 使用Druid数据库连接池技术
     * */

    private static DataSource source1;
    static {
        try {
            //方式1
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
            //方式2
            Properties pros=new Properties();
            InputStream is=new FileInputStream(new File("src/druid.properties"));
            pros.load(is);
            source1 = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection3()throws Exception{

        Connection conn = source1.getConnection();
        return conn;
    }



    /**
     * @description: 关闭资源的操作
     * @param: [conn, ps]
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/3 9:07 下午
     */
    public static void closeResource(Connection conn, Statement ps) {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description: 关闭资源操作
     * @param: [conn, ps, rs]
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/4 8:41 下午
     */
    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
    * @description: 使用dbutils.jar中提供的DbUtils工具类 实现资源的关闭
    * @param: [conn, ps, rs]
    * @return: void
    * @author: Ling Jian
    * @date: 2019/12/18 11:20 下午
    */
    public static void closeResource1(Connection conn, Statement ps, ResultSet rs) {
//        try {
//            DbUtils.close(conn);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            DbUtils.close(ps);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            DbUtils.close(rs);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(ps);
        DbUtils.closeQuietly(rs);
    }

}


