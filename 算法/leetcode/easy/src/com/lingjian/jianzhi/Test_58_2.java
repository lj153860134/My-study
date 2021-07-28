package com.lingjian.jianzhi;

/**
 * @description: 字符串的左旋转操作是把字符串前面的
 *               若干个字符转移到字符串的尾部
 *               请定义一个函数实现字符串左旋转操作的功能
 * @author: Ling Jian
 * @date: 2020-07-06 19:35
 **/
public class Test_58_2 {
    public static void main(String[] args) {
        String s = "abcdefg";
        String res = reverseLeftWords(s, 2);
        System.out.println(res);

    }

    public static String reverseLeftWords(String s, int n) {
        StringBuilder sb=new StringBuilder();
        sb.append(s.substring(n,s.length()));
        sb.append(s.substring(0,n));
        return sb.toString();
    }
}
