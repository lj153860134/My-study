package cn.lingjian_1;

import java.lang.reflect.Constructor;

/**
 * @author lingjian
 * @date 2019/10/31 - 9:10 上午
 */
/*
* public Person(String name,int age,String address)
* */
public class ReflectDemo3 {
    public static void main(String[] args) throws Exception{
        //获取字节码对象
        Class c=Class.forName("cn.lingjian_1.Person");

        //获取带参构造方法对象
        Constructor  con=c.getConstructor(String.class,int.class,String.class);
        System.out.println(con);

        //通过带参构造方法创建对象
        Object obj=con.newInstance("凌健",25,"盐城");
        System.out.println(obj);
    }
}
