package com.lingjian.leetcode;

import java.util.HashMap;

/**
 * @description: 需要 n 阶你才能到达楼顶。
 *               每次你可以爬 1 或 2 个台阶
 *               你有多少种不同的方法可以爬到楼顶
 * @author: Ling Jian
 * @date: 2020-06-13 16:12
 **/
public class Test_70 {
    public static void main(String[] args) {
        int n=40;
        long time1 = System.currentTimeMillis();
        int res1 = climbStairs1(n);
        long time2=System.currentTimeMillis();
        int res2 = climbStairs2(n);
        long time3=System.currentTimeMillis();
        System.out.println(res1);
        System.out.println(res2);

        System.out.println(time2-time1);
        System.out.println(time3-time2);

    }

    //暴力递归
    public static int climbStairs1(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return climbStairs1(n-1)+climbStairs1(n-2);
    }



    public static int climbStairs2(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        for (int i = 3; i <n+1 ; i++) {
            int res = map.get(i - 1) + map.get(i - 2);
            map.put(i, res);
        }
        return map.get(n);

    }

    public static int climbStairs3(int n) {
        int[] dp = new int[n + 1];
        dp[1]=1;
        dp[2] = 2;
        for (int i = 3; i <n+1 ; i++) {
            dp[i] = dp[i-1] + dp[i - 2];
        }
        return dp[n];
    }
}
