package com.lingjian_7.dao;

import com.lingjian_3.JDCBUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 封装了针对数据表通用的增删改查的操作
 * @author: Ling Jian
 * @date: 2019-12-13 21:02
 **/
public abstract class BaseDao {

    /**
    * @description: 通用的增删改操作（考虑到事务）
    * @param: [conn, sql, args]
    * @return: int
    * @author: Ling Jian
    * @date: 2019/12/13 9:14 下午
    */
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
            JDCBUtils.closeResource(null, ps);
        }
        return 0;

    }

    /**
    * @description: 通用的查操作 查询表一个数据对象（考虑到事务）
    * @param: [conn, c, sql, args]
    * @return: T
    * @author: Ling Jian
    * @date: 2019/12/13 9:15 下午
    */
    public <T> T getInstance( Connection conn,Class<T> c,String sql,Object...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i <args.length ; i++) {
                ps.setObject(i+1,args[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if(rs.next()){
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
            JDCBUtils.closeResource(null,ps,rs);
        }
        return null;
    }

    /**
    * @description: 通用的查操作 查询表多条数据对象的集合（考虑到事务
    * @param: [conn, c, sql, args]
    * @return: java.util.List<T>
    * @author: Ling Jian
    * @date: 2019/12/13 9:19 下午
    */
    public <T> List<T> getForList(Connection conn, Class<T> c, String sql, Object...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i <args.length ; i++) {
                ps.setObject(i+1,args[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            List<T> list=new ArrayList<>();
            while(rs.next()){
                T t=c.newInstance();
                for (int i = 0; i <columnCount ; i++) {
                    Object value=rs.getObject(i+1);
                    String ColumnLabel=rsmd.getColumnLabel(i+1);
                    Field field=c.getDeclaredField(ColumnLabel);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                list.add(t);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(null,ps,rs);
        }
        return null;
    }
    /**
    * @description: 查询一些特殊值的通用方法
    * @param: [conn, sql, args]
    * @return: E
    * @author: Ling Jian
    * @date: 2019/12/13 9:27 下午
    */
    public <E> E getValue(Connection conn,String sql,Object...args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i <args.length ; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            if(rs.next()){
                return (E)rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(null,ps,rs);
        }
        return null;
    }

}
