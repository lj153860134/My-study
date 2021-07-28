package com.lingjian_2;

import org.junit.Test;
import com.lingjian_3.JDCBUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lingjian
 * @date 2019/12/3 - 7:11 下午
 */

/*
 *使用PreparedStatement代替Statement
 * 实现对数据库的CRUD操作
 * 这里增删改
 */
public class PreparedStatementDemo {

    @Test
    public void testCRU(){
        update("update customers set name=? where id=?","徐小萌",20);
    }

    /**
    * @description: 通用的增删改操作
    * @param: [sql, args]
    * @return: void
    * @author: Ling Jian
    * @date: 2019/12/4 7:53 下午
    */

    public void update(String sql,Object...args) {
        //sql中的占位符的个数与args的长度一致
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            //获取数据库连接
            conn = JDCBUtils.getConnection();

            //预编译sql语句 返回PreparedStatement实例
            ps = conn.prepareStatement(sql);
            for (int i = 0; i <args.length ; i++) {
                ps.setObject(i+1,args[i]);//小心参数
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,ps);
        }

    }


    /**
    * @description: 向customer表中添加一条记录
    * @param: [ ]
    * @return: void
    * @author: Ling Jian
    * @date: 2019/12/4 7:11 下午
    */
    @Test
    public  void testInsert()  {
        Connection conn= null;
        PreparedStatement ps = null;
        try {
            //获取数据库连接
            conn = JDCBUtils.getConnection();
            //预编译sql语句 返回PreparedStatement实例
            String sql="insert into customers(name,email,birth) values(?,?,?)";
            ps = conn.prepareStatement(sql);

            //填充占位符
            ps.setObject(1,"凌健");
            ps.setObject(2,"123456789@qq.com");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date date=sdf.parse("1994-06-08");
            java.sql.Date date1=new java.sql.Date(date.getTime());
            ps.setDate(3, date1);

            //执行操作
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDCBUtils.closeResource(conn,ps);
        }


    }


}
