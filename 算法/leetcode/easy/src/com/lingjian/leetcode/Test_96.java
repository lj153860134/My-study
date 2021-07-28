package com.lingjian.leetcode;

/**
 * @description: 整数n  组成二叉搜索树的个数
 * @author: Ling Jian
 * @date: 2020-05-27 15:54
 **/
public class Test_96 {
    public static void main(String[] args) {
        int n=10;
        //暴力递归
        int res1 = numTrees1(n);
        //动态规划
        int res2 = numTrees2(n);
        System.out.println(res1);
        System.out.println(res2);
    }

    public static int numTrees1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int res=0;
        for (int i = 1; i <=n; i++) {
            res += numTrees1(i - 1) * numTrees1(n - i);
        }
        return res;
    }

    public static int numTrees2(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            for (int j = 0; j <i ; j++) {
                dp[i] += dp[j] * dp[i - j-1];
            }
        }
        return dp[n];
    }


}
