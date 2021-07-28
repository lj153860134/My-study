package com.lingjian.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 输入一个字符串
 *                打印出该字符串中字符的所有排列
 * @author: Ling Jian
 * @date: 2020-06-28 17:47
 **/
public class Test_38 {
    public static void main(String[] args) {
        String s = "aba";
        String[] res = permutation(s);
        System.out.println(Arrays.toString(res));
    }

    static List<String> list = new ArrayList<>();
    public static String[] permutation(String s) {
        char[] chs = s.toCharArray();
        process(chs,0);

        return list.toArray(new String[list.size()]);


    }

    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            list.add(String.valueOf(chs));
            return;
        }
        HashSet<Character> set=new HashSet<Character>();
        for (int j = i; j < chs.length; j++) {
            if(set.contains(chs[j])){
                continue;
            }
            set.add(chs[j]);
            swap(chs, i, j);
            process(chs, i + 1);
            swap(chs, i, j);

        }
    }

    public static void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j]=temp;
    }
}
