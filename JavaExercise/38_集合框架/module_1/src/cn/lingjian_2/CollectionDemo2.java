package cn.lingjian_2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author lingjian
 * @date 2019-09-15 - 14:52
 */
public class CollectionDemo2 {
    public static void main(String[] args) {
        Collection c1=new ArrayList();
        c1.add("abc1");
        c1.add("abc2");
        c1.add("abc3");
        c1.add("abc4");

        Collection c2=new ArrayList();
        c2.add("abc5");
        c2.add("abc6");
        c2.add("abc7");
        System.out.println(c1);
        System.out.println(c2);
        c1.addAll(c2);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println("--------");

        //遍历数组
        Object[] objs=c1.toArray();
        for (int i = 0; i <objs.length ; i++) {
            System.out.println(objs[i]);
            String s=(String) objs[i]; //向下转型
            System.out.println(s);

        }

    }
}
