package com.lingjian_1;


import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description: 连接测试
 * @author: Ling Jian
 * @date: 2019-12-10 20:48
 **/
public class ConnectionTest {
    @Test
    public void test()  {
        Connection conn=null;
        try {
            conn = JDBCUtils.getConnection();
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn!=null)
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}
