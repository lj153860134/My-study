package cn.lingjian_1;

import java.io.IOException;
import java.lang.reflect.Constructor;

/**
 * @author lingjian
 * @date 2019/10/31 - 9:27 上午
 */
/*
* 通过反射获取私有构造方法
* */
public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        Class c=Class.forName("cn.lingjian_1.Person");

        Constructor con=c.getDeclaredConstructor(String.class);
        System.out.println(con);

        //用该私有构造方法创建对象
        //设置访问权限
        con.setAccessible(true);
        Object obj=con.newInstance("凌健");
        System.out.println(obj);
    }
}
