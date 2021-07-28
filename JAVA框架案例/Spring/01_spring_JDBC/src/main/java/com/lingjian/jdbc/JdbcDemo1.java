package com.lingjian.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @description: 程序的耦合
 * @author: Ling Jian
 * @date: 2020-02-10 10:05
 **/
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception{
        //加载并注册驱动
//       DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy",
                "root","lj210910");
        //获取操作数据库的预处理对象
        PreparedStatement ps=conn.prepareStatement("select * from account");
        //执行Sql 得到结果集
        ResultSet rs=ps.executeQuery();
        //遍历结果集
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        //释放资源
        rs.close();
        ps.close();
        conn.close();
    }
}
