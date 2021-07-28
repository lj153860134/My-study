package com.lingjian.leetcode;

import java.util.Stack;

/**
 * @description: 给定两个字符串形式的非负整数num1和num2
 * 计算它们的和
 * @author: Ling Jian
 * @date: 2020-07-22 17:53
 **/
public class Test_415 {
    public static void main(String[] args) {
        String num1 = "4329432";
        String num2 = "84738";
        System.out.println(addStrings(num1, num2));
        System.out.println(Integer.valueOf(num1) + Integer.valueOf(num2));


    }

    public static String addStrings(String num1, String num2) {
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        int i = ch1.length - 1;
        int j = ch2.length - 1;
        int num = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? ch1[i] - '0' : 0;
            int b = j >= 0 ? ch2[j] - '0' : 0;
            int temp = a + b + num;
            num = temp / 10;
            sb.append(temp % 10);
            i--;
            j--;

        }
        if (num == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
