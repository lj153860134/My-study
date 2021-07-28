package cn.lingjian_4;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * @author lingjian
 * @date 2019-09-16 - 14:14
 */
public class ListDemo2 {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list);

        //在指定位置添加元素
        list.add(1,"lingjian");
        System.out.println(list);

        //获取功能
        System.out.println(list.get(1));
//        System.out.println(list.get(11)); 越界报错

        //删除功能
        System.out.println(list.remove(1));
        System.out.println(list);
//        list.remove("hello");//若没有该元素就不删除
//        System.out.println(list);

        //修改功能
        System.out.println(list.set(1,"lingjian"));
        System.out.println(list);
    }
}
