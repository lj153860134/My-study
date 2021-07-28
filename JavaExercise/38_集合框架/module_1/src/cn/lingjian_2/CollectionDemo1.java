package cn.lingjian_2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author lingjian
 * @date 2019-09-15 - 14:36
 */
public class CollectionDemo1 {
    public static void main(String[] args) {
//        Collection c=new Collection(); 接口不能实例化
       Collection c=new ArrayList();
        System.out.println(c.add("hello"));
        System.out.println(c);
        c.add("world");
        c.add("java");
        System.out.println(c);
//        c.clear();
//        System.out.println(c);
        System.out.println(c.remove("world"));
        System.out.println(c.remove("lingjian"));
        System.out.println(c);
        System.out.println(c.contains("hello"));
        System.out.println(c);
//        c.clear();
        System.out.println(c.isEmpty());
        System.out.println(c.size());


    }
}
