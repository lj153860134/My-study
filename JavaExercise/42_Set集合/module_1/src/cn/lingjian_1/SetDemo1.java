package cn.lingjian_1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lingjian
 * @date 2019/9/20 - 3:55 下午
 */
public class SetDemo1 {
    public static void main(String[] args) {
        Set<String> set=new HashSet<String>();
        set.add("hello");
        set.add("world");
        set.add("java");
        set.add("world");
        set.add("java");


        //增强for循环遍历
        for (String s : set) {
            System.out.println(s);
        }
    }
}
