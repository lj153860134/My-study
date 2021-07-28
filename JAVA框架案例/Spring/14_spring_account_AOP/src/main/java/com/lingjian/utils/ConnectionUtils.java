package com.lingjian.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @description: 连接的工具类 用于从数据源中获取一个连接 并且实现和线程的绑定
 * @author: Ling Jian
 * @date: 2020-02-12 15:38
 **/
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程的连接
     *
     * @return
     */
    public Connection getThreadConnection() {
        try {
            //获取当前线程的连接
            Connection conn = tl.get();
            //判断当前线程上是否有连接
            if(conn==null){
                //从数据源中获取一个连接 并和线程绑定（就是存入ThreadLocal中）
                conn=dataSource.getConnection();
                tl.set(conn);
            }
            //返回当前线程上的连接
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}
