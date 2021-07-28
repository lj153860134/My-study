package cn.lingjian_1;

import java.util.HashSet;

/**
 * @author lingjian
 * @date 2019/9/20 - 4:14 下午
 */
public class HashSetDemo1 {
    public static void main(String[] args) {
        HashSet<String> hs=new HashSet<String>();
        //添加元素
        hs.add("hello");
        hs.add("world");
        hs.add("java");
        hs.add("world");

        for (String s : hs) {
            System.out.println(s);
        }
    }
}
