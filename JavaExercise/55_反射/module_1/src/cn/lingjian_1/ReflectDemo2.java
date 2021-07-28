package cn.lingjian_1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author lingjian
 * @date 2019/10/30 - 4:41 下午
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取字节码文件对象
        Class c=Class.forName("cn.lingjian_1.Person");

        //获取公共构造方法
        Constructor[] cons=c.getConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }
        System.out.println("---------");
        //获取所有的构造方法
        Constructor[] cons2=c.getDeclaredConstructors();
        for (Constructor con : cons2) {
            System.out.println(con);
        }
        System.out.println("--------");

        Constructor con3=c.getConstructor();
        System.out.println(con3);
        Object obj=con3.newInstance();
        System.out.println(obj);

    }
}
