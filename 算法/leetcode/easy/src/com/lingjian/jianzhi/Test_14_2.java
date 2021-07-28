package com.lingjian.jianzhi;

import java.util.Arrays;

/**
 * @description: 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 *               每段绳子的长度记为 k[0],k[1]...k[m]
 *               请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少
 * @author: Ling Jian
 * @date: 2020-06-03 16:14
 **/
public class Test_14_2 {
    public static void main(String[] args) {
        int n = 10;
        int res = cuttingRope(n);
        System.out.println(res);
    }


    //动态规划
    //dp[i][j]代表长度为i分成j段的最大乘积
    //目标值是dp二维数组第n行的最大值
    public static int cuttingRope(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <n+1 ; i++) {
            dp[i][1] = i;
        }
        for (int i = 2; i <n+1; i++) {
            for (int j = 2; j <i+1 ; j++) {
                for (int k = 1; k <i-j+2 ; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - k][j - 1] * k);
                }
            }
        }

//        printArrays(dp);
        int max = Integer.MIN_VALUE;
        for (int i = 2; i <n+1 ; i++) {
            max = Math.max(dp[n][i], max);
        }
        return max;
    }

    public static void printArrays(int[][] arr) {
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }


}
