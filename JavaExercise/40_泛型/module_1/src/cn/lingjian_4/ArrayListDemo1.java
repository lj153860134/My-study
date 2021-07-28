package cn.lingjian_4;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author lingjian
 * @date 2019-09-17 - 20:17
 */
/*
* ArrayList存储字符串并遍历 要求加入泛型 增强for遍历
* 有3种遍历方式 A：迭代器
*             B：普通for循环
*             C：增强for循环
*
* */
public class ArrayListDemo1 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("java");

        //迭代器遍历
        Iterator<String> it=list.iterator();//这里也要加<String> 后面就不要加了
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("-------");

        //普通for循环遍历
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
        System.out.println("--------");

        //增强for循环遍历
        if(list!=null) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
