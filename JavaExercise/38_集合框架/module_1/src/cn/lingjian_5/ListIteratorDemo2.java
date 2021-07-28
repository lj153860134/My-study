package cn.lingjian_5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author lingjian
 * @date 2019-09-16 - 14:53
 */
public class ListIteratorDemo2 {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("java");
//        错误方法
//        Iterator it=list.iterator();
//        while(it.hasNext()){
//            String s=(String) it.next();
//            if(s.equals("world")){
//               list.add("javeee");   //无法添加元素
//            }
//        }

//      方式1：迭代器迭代元素 迭代器修改元素
//        ListIterator lit=list.listIterator();
//        while(lit.hasNext()){
//            String s=(String)lit.next();
//            if(s.equals("world")){
//                lit.add("javaee");
//            }
//        }

//       方式2：集合遍历元素 集合修改元素
        for (int i = 0; i <list.size() ; i++) {
            String s=(String) list.get(i);
            if(s.equals("world"))
                list.add("javaee");
        }
        System.out.println(list);

    }
}
