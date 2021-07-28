package com.lingjian_6;

import com.lingjian_3.JDCBUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @description: 使用PreparedStatement实现批量数据的操作
 * @author: Ling Jian
 * @date: 2019-12-09 21:17
 **/
public class InsertTest {
    @Test
    public void testInsert1() {
        //方式1：使用PreparedStatement批量操作
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDCBUtils.getConnection();
            String sql="insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <=10 ; i++) {
                ps.setObject(1,"name_"+i);
                ps.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,ps);
        }
    }

    //方式2：
    //addBatch()  executeBatch()  clearBatch()
    @Test
    public void testInsert2(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDCBUtils.getConnection();
            String sql="insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <=10 ; i++) {
                ps.setObject(1,"name_"+i);
                //用Batch“攒”sql
                ps.addBatch();
                if(i%500==0){
                    //执行Batch
                    ps.executeBatch();
                    //清空Batch
                    ps.clearBatch();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,ps);
        }
    }

    //方式3：
    //addBatch()  executeBatch()  clearBatch()
    //设置不允许提交数据 setAutoCommit(false)
    @Test
    public void testInsert3(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDCBUtils.getConnection();
            //设置不允许提交数据
            conn.setAutoCommit(false);
            String sql="insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <=10 ; i++) {
                ps.setObject(1,"name_"+i);
                //用Batch“攒”sql
                ps.addBatch();
                if(i%500==0){
                    //执行Batch
                    ps.executeBatch();
                    //清空Batch
                    ps.clearBatch();
                }
            }
            //提交数据
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,ps);
        }
    }
}
