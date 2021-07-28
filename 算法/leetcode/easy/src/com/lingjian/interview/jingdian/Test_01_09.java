package com.lingjian.interview.jingdian;

/**
 * @description: 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成
 * （比如，waterbottle是erbottlewat旋转后的字符串）。
 * @author: Ling Jian
 * @date: 2020-06-03 17:45
 **/
public class Test_01_09 {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(isFlipedString(s1, s2));
    }

    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s1 + s1).contains(s2);

    }
}
