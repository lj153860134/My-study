package com.lingjian_5;

import com.lingjian_2.Customers;
import com.lingjian_3.JDCBUtils;
import org.junit.Test;

import java.io.*;
import java.sql.*;

/**
 * @description: 测试使用PreparedStatement操作Blob类型的数据
 * @author: Ling Jian
 * @date: 2019-12-09 19:48
 **/
public class BlobTest {
    //向数据表customers中插入Blob类型的字段
    @Test
    public void testInsert() throws Exception{
        Connection conn = JDCBUtils.getConnection();
        FileInputStream fis=new FileInputStream("25-203.jpg");
        String sql="update customers set photo=? where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setBlob(1,fis);
        ps.setObject(2,19);
        ps.execute();
        fis.close();
        JDCBUtils.closeResource(conn,ps);
    }
    //查询数据表customers中Blob类型的字段
    @Test
    public void testSelect() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream is= null;
        FileOutputStream fos= null;
        try {
            conn = JDCBUtils.getConnection();
            String sql="select id ,name,email,birth,photo from customers where id=?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,19);
            rs = ps.executeQuery();
            if(rs.next()){
                //方式1
    //            int id=rs.getInt(1);
    //            String name=rs.getString(2);
    //            String email=rs.getString(3);
    //            Date birth=rs.getDate(4);
                //方式2
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String email=rs.getString("email");
                Date birth=rs.getDate("birth");


                Customers c=new Customers(id,name,email,birth);
                System.out.println(c);

    //            FileOutputStream fos=new FileOutputStream(new File("25_203.jpg"));
                //将Blob类型的字段下载下来 以文件的方式保存在本地
                Blob blob=rs.getBlob("photo");
                 is = blob.getBinaryStream();
                fos=new FileOutputStream("25_203.jpg");
                int len=0;
                byte[] bys=new byte[1024];
                while((len=is.read(bys))!=-1){
                    fos.write(bys,0,len);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(fos!=null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(is!=null)
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDCBUtils.closeResource(conn,ps,rs);
        }


    }
}
