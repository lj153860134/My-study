package cn.lingjian_7;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author lingjian
 * @date 2019-09-17 - 14:13
 */
/*
* 用LinkedList模拟栈数据结构的集合（先进后出） 并测试
*
* */
public class LinkedListDemo1 {
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        //用LinkedList特有的添加功能addFirst（）
        list.addFirst("hello");
        list.addFirst("world");
        list.addFirst("java");

        //用迭代器遍历
        Iterator it=list.iterator();
        while(it.hasNext()){
            String s=(String)it.next();
            System.out.println(s);
        }

    }
}
