package com.lingjian_1;

import java.util.Arrays;

/**
 * @description: 背包问题
 * @author: Ling Jian
 * @date: 2020-03-05 17:42
 **/
public class hh {
    public static int maxValue1(int[] c, int[] p, int bag) {
        return process1(c, p, 0, 0, bag);
    }

    public static int process1(int[] weights, int[] values, int i, int alreadyweight, int bag) {
        if (i == weights.length||alreadyweight>bag) {
            return 0;
        }
        if (alreadyweight + weights[i] <= bag) {
            return Math.max(

                    process1(weights, values, i + 1, alreadyweight, bag),

                    values[i] + process1(weights, values, i + 1, alreadyweight + weights[i], bag));
        }

        return process1(weights, values, i + 1, alreadyweight, bag);

    }

    public static int maxValue2(int[] c, int[] p, int bag) {
        int[][] dp = new int[c.length + 1][bag + 1];
        for (int i = c.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + c[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
                }
            }
        }
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] c1 = {3, 2, 4, 7};
        int[] p1 = {5, 6, 3, 19};
        int bag1 = 11;

        int[] c2 = {1, 3};
        int[] p2 = {1, 1};
        int bag2 = 2;
        System.out.println(maxValue1(c1, p1, bag1));
        System.out.println(maxValue2(c1, p1, bag1));
        System.out.println("========");
        System.out.println(maxValue1(c2, p2, bag2));
        System.out.println(maxValue2(c2, p2, bag2));
    }
}
