package cn.lingjian_2;

import java.util.LinkedHashSet;

/**
 * @author lingjian
 * @date 2019/9/20 - 9:09 下午
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> hs=new LinkedHashSet<String>();

        hs.add("hello");
        hs.add("world");
        hs.add("java");
        hs.add("hello");
        hs.add("world");

        for (String h : hs) {
            System.out.println(h);
        }
    }
}
