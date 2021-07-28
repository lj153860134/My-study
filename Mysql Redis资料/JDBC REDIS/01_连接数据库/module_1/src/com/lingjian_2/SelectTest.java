package com.lingjian_2;

import com.lingjian_3.JDCBUtils;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

/**
 * @description: 解决sql的注入问题
 * @author: Ling Jian
 * @date: 2019-12-05 21:34
 **/
public class SelectTest {
    @Test
    public void test1() {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的用户名");
        String userName = sc.nextLine();
        System.out.println("请输入你的密码");
        String passWord = sc.nextLine();
        String sql = "select user,password from user_table where user=? and password=?";
        User user = selectFromTable(User.class, sql, userName, passWord);
//        System.out.println(user);
        if (user != null) {
            System.out.println("登入成功");
        } else {
            System.out.println("用户名不存在或密码错误");
        }

    }

    /**
     * @description: 针对不同表的通用查询方式1
     * @param: [Class c, sql, args]
     * @return: T 直接返回该表的一个对象
     * @author: Ling Jian
     * @date: 2019/12/5 9:18 下午
     */
    public <T> T selectFromTable(Class<T> c, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //这里是多态 Connection是一个接口
            //返回的mysql中具体实现类的对象
            conn = JDCBUtils.getConnection();
            //这里调用prepareStatement的是mysql中具体实现类重写的方法
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                //两种通过反射 创建T的实例
//                Constructor con =c.getDeclaredConstructor();
//                con.setAccessible(true);
//                T t=(T)con.newInstance();
                T t = c.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object value = rs.getObject(i + 1);
                    String ColumnLabel = rsmd.getColumnLabel(i + 1);
                    Field field = c.getDeclaredField(ColumnLabel);
                    field.setAccessible(true);
                    field.set(t, value);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn, ps, rs);
        }
        return null;
    }
}
