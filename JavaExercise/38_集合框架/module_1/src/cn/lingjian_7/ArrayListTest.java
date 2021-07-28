package cn.lingjian_7;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author lingjian
 * @date 2019-09-17 - 10:24
 */
/*
* 需求：ArrayList去除集合中字符串的重复值（字符串的内容相同）
* */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("java");
        list.add("java");
//        list.add("java");
        list.add("world");
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("world");
        list.add("hello");

        System.out.println(list);

        //用for循环遍历集合 不好
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int count=0;
                String s1 = (String) list.get(i);
                String s2 = (String) list.get(j-count);
                if (s1.equals(s2)) {
                    list.remove(i);
                    System.out.println(list);
                }
            }
        }


        //用两个集合来遍历做
        ArrayList newList = new ArrayList(); //创建新集合
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            if (!newList.contains(s))
                newList.add(s);
        }
        System.out.println(newList);
        for (int i = 0; i <newList.size() ; i++) {
            String s1=(String)newList.get(i);
            System.out.println(s1);

        }
    }
}

