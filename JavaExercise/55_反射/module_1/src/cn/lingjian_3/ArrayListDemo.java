package cn.lingjian_3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author lingjian
 * @date 2019/10/31 - 2:36 下午
 */
/*
* 需求 在ArrayLis<Integer>中添加一个字符串数据
*
* */
public class ArrayListDemo {
    public static void main(String[] args) throws Exception{
        //创建集合对象
        ArrayList<Integer> list=new ArrayList<Integer>();

//        list.add("hello");//因为有了泛型机制 无法添加字符串
        //用反射机制
        Class c=list.getClass();

        Method method=c.getMethod("add",Object.class);
        method.invoke(list,"hello");
        System.out.println(list);



    }
}
