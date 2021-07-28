package cn.lingjian_7;

import java.util.ArrayList;

/**
 * @author lingjian
 * @date 2019-09-17 - 10:59
 */
public class ArrayListTest2 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("java");
        list.add("java");
        list.add("world");
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("world");
        list.add("hello");

        System.out.println(list);

        //用for循环遍历集合
        int count=0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                String s1 = (String) list.get(i);
                String s2 = (String) list.get(j);
                if (s1.equals(s2)) {
                    list.remove(j);
                    j--;//直接做一个自减即可
                    System.out.println(list);
                }
            }
        }
    }

}
