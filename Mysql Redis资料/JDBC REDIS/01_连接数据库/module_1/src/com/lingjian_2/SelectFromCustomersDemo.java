package com.lingjian_2;

import com.lingjian_3.JDCBUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @description: 实现对Customers表的查询操作
 * @author: Ling Jian
 * @date: 2019-12-04 20:07
 **/
public class SelectFromCustomersDemo {

    @Test
    public void testSelect(){
        String sql="select id,name,birth,email from customers where id between ? and ?";
        queryForCustomers(sql,1,10);

    }
    /**
    * @description: 对Customers表的通用查询操作
    * @param: [sql, args]
    * @return: void
    * @author: Ling Jian
    * @date: 2019/12/4 8:56 下午
    */
    public void queryForCustomers(String sql,Object...args){
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
            //获取结果集的元数据 ResultSetMetaDate
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                Customers c=new Customers();
                //c处理结果集一行数据中的每一个列
                for (int i = 0; i <columnCount ; i++) {
                    //获取列值
                    Object value = rs.getObject(i + 1);//注意参数
                    //获取没每个列的列名（别名）
                    //在sql语句中添加别名
                    // 保证与每个类的属性名一致
//                    String columnName = rsmd.getColumnName(i+1);
                    String columnLabel=rsmd.getColumnLabel(i+1);

                    //给c对象指定的属性 赋值为value 通过反射(2种方式都行）
//                    Field field = c.getClass().getDeclaredField(columnLabel);
                    Field field = Customers.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(c,value);

                }
                System.out.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn,ps,rs);
        }



    }
    @Test
    public void testDemo1() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;//rs最后也需要关闭 要重写closeResource()方法
        try {
            conn = JDCBUtils.getConnection();
            String sql = "select id,name,email,birth from customers where id=?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, 20);

            //执行（与之前的不同）并返回结果集
            rs = ps.executeQuery();
            //处理结果集
            while (rs.next()) { //判断结果集的下一条是否有数据
                //有数据返回true 指针并下移
                //获取当前数据的各个字段值
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                Date birth = rs.getDate(4);

                //方式1 直接显示
                //            System.out.println(" id= "+id+",name= "+name+",email= "+email+",birth= "+birth);

                //方式2 将数据封装成一个对象（推荐）
                Customers c = new Customers(id, name, email, birth);
                System.out.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDCBUtils.closeResource(conn, ps, rs);
        }

    }
}

