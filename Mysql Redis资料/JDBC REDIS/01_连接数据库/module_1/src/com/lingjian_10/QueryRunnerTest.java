package com.lingjian_10;

import com.lingjian_2.Customers;
import com.lingjian_3.JDCBUtils;
import jdk.swing.interop.SwingInterOpUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2019-12-18 21:07
 **/
public class QueryRunnerTest {
    //测试插入
    @Test
    public void testInsert(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDCBUtils.getConnection3();
            String sql="insert into customers(name,email,birth) values(?,?,?)";
            int insertCount=runner.update(conn,sql,"蔡徐坤","1234@qq.com","1999-09-09");
            System.out.println(insertCount);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,null);
        }
    }

    //测试查询 BeanHandler是ResultSetHandler接口的实现类
    //       用于封装表中的一条记录
    @Test
    public void testQuery1(){
        Connection conn=null;
        try {
            QueryRunner runner = new QueryRunner();
            conn=JDCBUtils.getConnection2();
            String sql="select id,name,email,birth from customers where id=?";
            BeanHandler<Customers> handler=new BeanHandler<Customers>(Customers.class);
            Customers customers = runner.query(conn, sql, handler, 25);
            System.out.println(customers);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,null);
        }
    }

    //测试查询 BeanListHandler是ResultSetHandler接口的实现类
    //       对应表中的多条记录
    @Test
    public void testQuery2(){
        Connection conn=null;

        try {
            QueryRunner runner = new QueryRunner();
             conn=JDCBUtils.getConnection2();
            String sql="select id,name,email,birth from customers where id between ? and ?";
            BeanListHandler<Customers> handler=new BeanListHandler<Customers>(Customers.class);
            List<Customers> customersList = runner.query(conn, sql, handler, 1,10);
//        for (Customers customers : customersList) {
//            System.out.println(customers);
//        }

            customersList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,null);
        }
    }
    //测试查询 BeanHandler是ResultSetHandler接口的实现类
    //       对应表中的一条记录 将字段及相应字段的值作为map的key value
    //
    @Test
    public void testQuery3(){
        Connection conn=null;
        try {
            QueryRunner runner = new QueryRunner();
            conn=JDCBUtils.getConnection2();
            String sql="select id,name,email,birth from customers where id=?";
            MapHandler handler=new MapHandler();
            Map<String,Object> map = runner.query(conn, sql, handler, 25);
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,null);
        }
    }

    //测试查询 BeanListHandler是ResultSetHandler接口的实现类
    //       对应表中的多条记录 将字段及相应字段的值作为map的key value
    //       将这些map添加到List中
    @Test
    public void testQuery4(){
        Connection conn=null;
        try {
            QueryRunner runner = new QueryRunner();
            conn=JDCBUtils.getConnection2();
            String sql="select id,name,email,birth from customers where id between ? and ?";
            MapListHandler handler=new MapListHandler();
          List<Map<String,Object>> list = runner.query(conn, sql, handler, 1,10);
//            for (Map<String, Object> map : list) {
//                System.out.println(map);
//            }

            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,null);
        }
    }

    //ScalarHandler 用于查询特殊值
    @Test
    public void testQuery5(){
        Connection conn=null;
        try {
            QueryRunner runner = new QueryRunner();
            conn=JDCBUtils.getConnection2();
            String sql="select count(*) from customers ";
            ScalarHandler handler = new ScalarHandler();
            long res=(long)runner.query(conn,sql,handler);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,null);
        }
    }

    //自定义ResultSetHandler的实现类
    @Test
    public void testQuery6(){
        Connection conn=null;
        try {
            QueryRunner runner = new QueryRunner();
            conn=JDCBUtils.getConnection2();
            String sql="select id,name,email,birth from customers where id=?";
            ResultSetHandler<Customers> handler=new ResultSetHandler<Customers>() {
                @Override
                public Customers handle(ResultSet rs) throws SQLException {
                   if(rs.next()){
                       int id=rs.getInt("id");
                       String name = rs.getString("name");
                       String email = rs.getString("email");
                       Date birth=rs.getDate("birth");
                       Customers customer=new Customers(id,name,email,birth);
                       return customer;
                   }
                   return null;
                }
            };
            System.out.println(runner.query(conn, sql, handler, 25));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,null);
        }
    }
}
