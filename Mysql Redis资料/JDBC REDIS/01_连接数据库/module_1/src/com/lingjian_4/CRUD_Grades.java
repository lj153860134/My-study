package com.lingjian_4;

import com.lingjian_3.JDCBUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

/**
 * @description: 增删改查四六级表
 * @author: Ling Jian
 * @date: 2019-12-06 22:11
 **/
public class CRUD_Grades {

    /**
     * @description: 对四六级表添加学生数据
     * @param: []
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/6 10:42 下午
     */
    @Test
    public void InsertTest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("选择4/6级");
        int type = sc.nextInt();
        System.out.println("请输入身份证号码");
        String IdCard = sc.next();
        System.out.println("请输入准考证号");
        String ExamCard = sc.next();
        System.out.println("请输入学生姓名");
        String name = sc.next();
        System.out.println("请输入区域");
        String location = sc.next();
        System.out.println("请输入成绩");
        int grade = sc.nextInt();

        String sql = "Insert into examstudent(Type,IDCard,ExamCard,StudentName,Location,Grade) values(?,?,?,?,?,?)";
        int countColumn = update(sql, type, IdCard, ExamCard, name, location, grade);
        if (countColumn > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }


    }

    @Test
    public void deleteTest(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学生的考号");
        String examCard=sc.next();
        String sql="delete from examstudent where examCard=?";
        int deleteCount=update(sql,examCard);
        if(deleteCount>0){
            System.out.println("删除成功");
        }else{
            System.out.println("查无此人");
        }

    }

    @Test
    public void SelectTest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要输入的类型");
        System.out.println("a:准考证号");
        System.out.println("b:身份证号");
        String selection = sc.next();
        //调用"a"和"b"的equalsIgnoreCase
        //保证程序的健壮性
        //selection可能是为null
        if ("a".equalsIgnoreCase(selection)) {
            System.out.println("请输入准考证号");
            String examCard = sc.next();
            String sql = "select FlowID flowId,Type type,IDCard idCard,ExamCard examCard,StudentName name,Location location,Grade grade " +
                    "from examstudent where examCard=?";

            //两个连接的"" 之间的空格不要忘了
            Students student = select(Students.class, sql, examCard);
            if (student != null) {
                System.out.println("========查询结果========");
                System.out.println(student);
            } else {
                System.out.println("查无此人");
            }
        } else if ("b".equalsIgnoreCase(selection)) {
            System.out.println("请输入身份证号");
            String idCard = sc.next();
            String sql = "select FlowID flowId,Type type,IDCard idCard,ExamCard examCard,StudentName name,Location location,Grade grade" +
                    "from examstudent where IDCard=?";
            Students student = select(Students.class, sql, idCard);
            if (student != null) {
                System.out.println("========查询结果========");
                System.out.println(student);
            } else {
                System.out.println("查无此人");
            }
        } else {
            System.out.println("输入有误");
        }


    }

    public int update(String sql, Object... args) {
        //sql中的占位符的个数与args的长度一致
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            //获取数据库连接
            conn = JDCBUtils.getConnection();

            //预编译sql语句 返回PreparedStatement实例
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);//小心参数
            }
            return ps.executeUpdate();
            //executeUpdate 返回增删改语句对数据库影响的行数
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDCBUtils.closeResource(conn, ps);
        }
        return 0;  //若影响的行数为0 则增删改失败

    }

    public <T> T select(Class<T> c, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDCBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
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
