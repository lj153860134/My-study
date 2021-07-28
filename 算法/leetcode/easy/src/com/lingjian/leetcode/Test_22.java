package com.lingjian.leetcode;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
 * @author: Ling Jian
 * @date: 2020-06-15 17:10
 **/
public class Test_22 {
    public static void main(String[] args) {
        int n = 3;
        generateParenthesis(n);
//        List<String> list = generateParenthesis(n);
//        System.out.println(Arrays.toString(list.toArray()));
//        list = generateParenthesis1(n);
//        System.out.println(Arrays.toString(list.toArray()));

    }

    //dfs
    static List<String> res1 = new ArrayList<>();
    static List<String> res2 = new ArrayList<>();
    public static void generateParenthesis(int n) {
        dfs(n, n, "");
        dfs1(n, n, "");
        System.out.println(Arrays.toString(res1.toArray()));
        System.out.println(Arrays.toString(res2.toArray()));
    }



    private static void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res1.add(curStr);
            return;
        }
        if(left>right){
            return;
        }
        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(");
        }
        if (right >0) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")");
        }
    }

    private static void dfs1(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res2.add(curStr);
            return;
        }

        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs1(left - 1, right, curStr + "(");
        }
        if (right >left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs1(left, right - 1, curStr + ")");
        }
    }

    //动态规划
// 把结果集保存在动态规划的数组里

    public List<String> generateParenthesis1(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // 这里 dp 数组我们把它变成列表的样子，方便调用而已
        List<List<String>> dp = new ArrayList<>(n);

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // 枚举右括号的位置
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }
}






