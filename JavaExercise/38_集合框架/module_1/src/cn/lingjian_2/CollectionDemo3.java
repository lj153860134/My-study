package cn.lingjian_2;

import cn.lingjian_1.Student;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author lingjian
 * @date 2019-09-15 - 15:04
 */
public class CollectionDemo3 {
    public static void main(String[] args) {
        Collection c=new ArrayList();
        c.add("abc1");
        c.add("abc2");
        c.add("abc3");
        c.add("abc4");

        Object obj1=new Object();
        obj1="hello"; //这里已经存在向上转型
        System.out.println(obj1);
        System.out.println(obj1.toString());//这里的已经是调用String类的toString方法了

        Object obj2=new Object();
        Student s=new Student("lingjian",24);
        obj2=s;  //向上转型
        System.out.println(obj2);
        System.out.println(obj2.toString());


        Object [] objs=c.toArray();
        for (int i = 0; i <objs.length; i++) {
            System.out.println(objs[i]);
            System.out.println(objs[i].toString().length());

        }
    }
}
