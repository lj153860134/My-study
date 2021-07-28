package cn.lingjian_5;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author lingjian
 * @date 2019-09-16 - 14:35
 */
public class ListIteratorDemo1 {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("java");

        //创建List特有的迭代器
        ListIterator lit=list.listIterator();//子类对象 可实现的具体类
        while(lit.hasNext()){
            String s=(String) lit.next();
            System.out.println(s);
        }
        System.out.println("--------");
//        while(lit.hasPrevious()){
//            String s1=(String) lit.previous();
//            System.out.println(s1);
//        }
    }
}
