package cn.lingjian_1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author lingjian
 * @date 2019/10/31 - 9:49 上午
 */
/*
* 通过反射获取成员变量并使用
* */
public class ReflectDemo5 {
    public static void main(String[] args) throws Exception{
        //获取字节码对象
        Class c=Class.forName("cn.lingjian_1.Person");

        //获取所有的成员变量
        Field[] fields=c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("--------");

        //通过无参构造方法创建对象
        Constructor con=c.getConstructor();
        Object obj=con.newInstance();
        System.out.println(obj);

        //获取单个成员变量 address并对其赋值
        Field addressField=c.getField("address");
        System.out.println(addressField);
        //赋值
        addressField.set(obj,"盐城");
        System.out.println(obj);

        //获取name成员变量 并赋值

        Field nameField=c.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(obj,"凌健");
        System.out.println(obj);

    }
}
