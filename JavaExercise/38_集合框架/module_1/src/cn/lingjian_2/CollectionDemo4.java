package cn.lingjian_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author lingjian
 * @date 2019-09-15 - 15:33
 */
public class CollectionDemo4 {
    public static void main(String[] args) {
        Collection c1=new ArrayList();
        c1.add("abc1");
        c1.add("abc2");
        c1.add("abc3");
        c1.add("abc4");
        //遍历集合
        Iterator it=  c1.iterator();
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());//NoSuchElementException
        while (it.hasNext()){
            String s=(String) it.next();//向下转型
//            System.out.println(s);
        }

    }
}
