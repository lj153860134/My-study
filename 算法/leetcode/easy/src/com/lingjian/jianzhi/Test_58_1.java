package com.lingjian.jianzhi;

import java.util.Arrays;

/**
 * @description: 输入一个英文句子
 *               翻转句子中单词的顺序
 *               但单词内字符的顺序不变
 *               为简单起见，标点符号和普通字母一样处理
 *               例如输入字符串"I am a student.
 *               则输出"student. a am I"。
 * @author: Ling Jian
 * @date: 2020-07-06 18:03
 **/
public class Test_58_1 {
    public static void main(String[] args) {
        String s = " lingjian ai XV  xiao  Meng   ";
        String res = reverseWords(s);
        System.out.println(res);
    }

    public static String reverseWords(String s) {
         s=s.trim();
        System.out.println(s);
        String[] str = s.split(" ");
        System.out.println(Arrays.toString(str));
        StringBuilder sb = new StringBuilder();
        for (int i = str.length-1; i>=0 ; i--) {
            if(!str[i].equals("")) {
                sb.append(str[i]+" ");
            }
        }
        return sb.toString().trim();
    }


}
