package com.lingjian.exercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 全部字符串的子序列和子串
 *               子序列（不连续）
 *               子串（连续）
 * @author: Ling Jian
 * @date: 2020-08-03 21:53
 **/
public class Demo1 {
    static List<String> list1 = new LinkedList<>();
    static List<String> list2 = new LinkedList<>();
    public static void main(String[] args) {
        String s="ab";
        char[] chs = s.toCharArray();
        process1(chs, 0, s.length(),"");
        System.out.println(Arrays.toString(list1.toArray()));
//        process(s);
//        System.out.println(Arrays.toString(list2.toArray()));
    }

    public static void process1(char[] chs,int i,int j,String s){
        if(i==j){
            list1.add(s);
            return;
        }
            process1(chs, i + 1, j, s);
            process1(chs, i + 1, j, s + chs[i]);

    }

    public static void process(String s){
        for (int i = 0; i <s.length() ; i++) {
            for (int j = i; j < s.length(); j++) {
                list2.add(s.substring(i, j+1 ));
            }
        }
    }
}
