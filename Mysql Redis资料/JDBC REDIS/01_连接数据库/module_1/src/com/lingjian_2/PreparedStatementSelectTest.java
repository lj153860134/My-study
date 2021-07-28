package com.lingjian_2;

import com.lingjian_3.JDCBUtils;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @description: 针对不同表的通用查询操作
 * @author: Ling Jian
 * @date: 2019-12-05 20:23
 **/
public class PreparedStatementSelectTest {

    @Test
    public void test1(){
        String sql="select id,name,birth,email from customers where id between ? and ?";
        selectFromTable1("com.lingjian_2.Customers",sql,2,10);
    }


    /** 
    * @description: 针对不同表的通用查询方式1
    * @param: [tableName, sql, args]
    * @return: void 无返回值
    * @author: Ling Jian 
    * @date: 2019/12/5 9:08 下午
    */ 
    public void selectFromTable1(String tableName,String sql,Object...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDCBUtils.getConnection3();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i <args.length ; i++) {
                ps.setObject(i+1,args[i]);
            }
            Class c=Class.forName(tableName);
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()){
                Constructor con =c.getDeclaredConstructor();
                con.setAccessible(true);
                Object obj=con.newInstance();
//                Object obj=c.newInstance();  也可以一步到位 不需要反射构造器
                for (int i = 0; i <columnCount ; i++) {
                    Object value=rs.getObject(i+1);
                    String ColumnLabel=rsmd.getColumnLabel(i+1);
                    Field field=c.getDeclaredField(ColumnLabel);
                    field.setAccessible(true);
                    field.set(obj,value);
                }
                System.out.println(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,ps,rs);
        }
    }

    /**
    * @description:  针对不同表的通用查询方式1
    * @param: [Class c, sql, args]
    * @return: T 直接返回该表的一个对象
    * @author: Ling Jian
    * @date: 2019/12/5 9:18 下午
    */
    public <T> T selectFromTable2(Class<T> c,String sql,Object...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDCBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i <args.length ; i++) {
                ps.setObject(i+1,args[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()){
                T t=c.newInstance();
                for (int i = 0; i <columnCount ; i++) {
                    Object value=rs.getObject(i+1);
                    String ColumnLabel=rsmd.getColumnLabel(i+1);
                    Field field=c.getDeclaredField(ColumnLabel);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,ps,rs);
        }
        return null;
    }
}
