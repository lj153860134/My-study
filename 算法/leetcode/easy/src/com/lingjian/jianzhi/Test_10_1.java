package com.lingjian.jianzhi;

import java.util.HashMap;

/**
 * @description: 写一个函数，输入 n
 *               求斐波那契（Fibonacci）数列的第 n 项
 * @author: Ling Jian
 * @date: 2020-06-21 17:34
 **/
public class Test_10_1 {
    public static void main(String[] args) {
        int n=5;
        System.out.println(fib1(n));
        System.out.println(fib2(n));
        System.out.println(fib3(n));
    }

    //暴力递归
    public static int fib1(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    //记忆化搜索
    static HashMap<Integer, Integer> map = new HashMap<>();
    static {
        map.put(0, 0);
        map.put(1, 1);
    }
    public static int fib2(int n) {
        for (int i = 2; i <=n ; i++) {
            map.put(i, map.get(i - 1) + map.get(i - 2));
        }
        return map.get(n);
    }

    public static int fib3(int n) {
        int[] dp = new int[n + 1];
        dp[0]=0;
        dp[1]=1;

        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
