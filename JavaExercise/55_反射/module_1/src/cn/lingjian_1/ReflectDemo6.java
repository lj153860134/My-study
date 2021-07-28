package cn.lingjian_1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author lingjian
 * @date 2019/10/31 - 10:40 上午
 */
/*
 * 通过反射获取成员方法
 * */
public class ReflectDemo6 {
    public static void main(String[] args) throws Exception {
        Class c = Class.forName("cn.lingjian_1.Person");

        //创建对象
        Constructor con = c.getConstructor();
        Object obj = con.newInstance();

        //获取所有方法
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        //获取show方法
        Method method1 = c.getDeclaredMethod("show");
        method1.setAccessible(true);
        method1.invoke(obj);
        System.out.println("--------");

        //获取无返回值的 带参method方法
        Method method2 = c.getDeclaredMethod("method", String.class);
        method2.setAccessible(true);
        method2.invoke(obj, "凌健");
        System.out.println("--------");

        //获取有返回值的 带参getString方法
        Method method3 = c.getDeclaredMethod("getString", String.class, int.class);
        method2.setAccessible(true);
        Object o1 = method3.invoke(obj, "凌健", 25);
        System.out.println("++++++++");
        System.out.println(o1);
        System.out.println("--------");

        //获取无返回值的 无参function私有成员方法
        Method method4 = c.getDeclaredMethod("function");
        method4.setAccessible(true);
        method4.invoke(obj);
        System.out.println("--------");
    }
}
