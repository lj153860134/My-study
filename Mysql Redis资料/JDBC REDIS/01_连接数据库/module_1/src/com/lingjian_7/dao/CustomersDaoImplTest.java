package com.lingjian_7.dao;

import com.lingjian_2.Customers;
import com.lingjian_3.JDCBUtils;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CustomersDaoImplTest {
        CustomersDaoImpl dao=new CustomersDaoImpl();
    @Test
    public void insert() {
        Connection conn= null;
        try {
            conn = JDCBUtils.getConnection();
            SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
            Date date=  sdf.parse("1994-06-08");
            Customers c1=new Customers(1,"凌健","153860134@qq.com", new java.sql.Date(date.getTime()));
            dao.insert(conn, c1);
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,null);
        }
    }

    @Test
    public void deleteById() {
        Connection conn=null;
        try {
            conn= JDCBUtils.getConnection();
            dao.deleteById(conn,22);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,null);
        }
    }

    @Test
    public void update() {
        Connection conn= null;
        try {
            conn = JDCBUtils.getConnection();
            SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
            java.sql.Date date=new java.sql.Date(sdf.parse("1995-08-23").getTime());
            Customers c2=new Customers(23,"徐小萌","12345678@qq.com",date);
            dao.update(conn,c2);
            System.out.println("更新成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,null);
        }


    }

    @Test
    public void getCustomerById() {
        Connection conn=null;
        try {
            conn=JDCBUtils.getConnection();
            Customers c3=dao.getCustomerById(conn,23);
            System.out.println(c3);
            System.out.println("获取成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,null);
        }

    }

    @Test
    public void getAll() {
        Connection conn=null;
        try {
            conn=JDCBUtils.getConnection();
            List<Customers> list=dao.getAll(conn);
//            for (Customers c : list) {
//                System.out.println(c);
//            }
            //lambda表达式
            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,null);
        }

    }

    @Test
    public void getCount() {
        Connection conn=null;
        try {
            conn=JDCBUtils.getConnection();
            System.out.println("表中的数据数目为 "+dao.getCount(conn));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,null);
        }

    }

    @Test
    public void getMaxBirth() {
        Connection conn=null;
        try {
            conn=JDCBUtils.getConnection();
            System.out.println("表中的最大的生日为 "+dao.getMaxBirth(conn));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,null);
        }
    }
}