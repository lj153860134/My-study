package com.lingjian.leetcode;

import java.util.HashMap;

/**
 * @description: 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 前五项如下:
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * @author: Ling Jian
 * @date: 2020-06-11 15:26
 **/
public class Test_38 {
    static HashMap<Integer, String> map = new HashMap<>();
    public static void main(String[] args) {
        map.put(1, "1");
        int n = 30;
        String res = countAndSay1(n);
        System.out.println(res);
    }

    //递归调用
    public static String countAndSay(int n) {
        if (n==1) {
            return "1";
        }
        String str = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char[] chs = str.toCharArray();
        int p = 0;
        int count;
        while (p < chs.length ) {
            char ch = chs[p];
            count = 0;
            while (p < chs.length  && ch == chs[p]) {
                count++;
                p++;
            }
            sb.append(count).append(ch);
        }
        return  sb.toString();
    }

    //放入map中 加速递归
    public static String countAndSay1(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        String str = countAndSay(n - 1);
        String res = "";
        char[] chs = str.toCharArray();
        int p = 0;
        int count;
        while (p < chs.length ) {
            char ch = chs[p];
            count = 0;
            while (p < chs.length  && ch == chs[p]) {
                count++;
                p++;
            }
            res = res + String.valueOf(count) + ch;
        }
        map.put(n, res);
        return  res;

    }




}
