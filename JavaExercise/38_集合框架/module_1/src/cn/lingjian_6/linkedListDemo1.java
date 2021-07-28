package cn.lingjian_6;
import java.util.LinkedList;

/**
 * @author lingjian
 * @date 2019-09-17 - 09:59
 */
/*
* linkedList类的特有功能
*
* */
public class linkedListDemo1 {
    public static void main(String[] args) {
        LinkedList link=new LinkedList();
        link.add("hello");
        link.add("world");
        link.add("java");
        //特有添加功能
        link.addFirst("lingjian");
        link.addLast("hehe");
        System.out.println(link);

        System.out.println(link.removeFirst());
        System.out.println(link.removeLast());
        System.out.println(link);

    }
}
