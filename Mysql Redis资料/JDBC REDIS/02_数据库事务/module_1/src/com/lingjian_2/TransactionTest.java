package com.lingjian_2;

import com.lingjian_1.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description: 事务测试
 * @author: Ling Jian
 * @date: 2019-12-10 21:18
 **/
public class TransactionTest {
    //针对数据表user_table
    //AA用户向BB转账100
    @Test
    public void testUpdate() {
        String sql1 = "update user_table set balance=balance-100 where user=?";
        String sql2 = "update user_table set balance=balance+100 where user=?";
        int num1 = update(sql1, "AA");
        int num2 = update(sql2, "BB");
        System.out.println(num1);
        System.out.println(num2);
    }

    //通用的增删改操作
    //*****************未考虑数据库事务情况下的转账******************
    public int update(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            //获取数据库连接
            conn = JDBCUtils.getConnection();
            //预编译sql语句 返回PreparedStatement实例
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);//小心参数
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps);
        }

        return 0;

    }

    @Test
    public void testUpdateWithTx() {
        //获取数据库连接
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            //取消数据的自动提交功能
            conn.setAutoCommit(false);
            String sql1 = "update user_table set balance=balance-100 where user=?";
            String sql2 = "update user_table set balance=balance+100 where user=?";
            int num1 = update(conn, sql1, "AA");

            //模拟网络异常
//            System.out.println(10/0);
            
            int num2 = update(conn, sql2, "BB");
            System.out.println(num1);
            System.out.println(num2);
            System.out.println("转账成功");

            //提交数据
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚数据
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            //关闭资源
            JDBCUtils.closeResource(conn, null);
        }

    }

    //*****************考虑数据库事务情况下的转账******************
    public int update(Connection conn, String sql, Object... args) {
        //sql中的占位符的个数与args的长度一致
        PreparedStatement ps = null;

        try {

            //预编译sql语句 返回PreparedStatement实例
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);//小心参数
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps);
        }

        return 0;

    }
}
