package com.lingjian_2;

import java.util.Arrays;

/**
 * @description: 暴力递归和动态规划 解决背包问题
 * @author: Ling Jian
 * @date: 2020-03-11 16:56
 **/
public class BagProblem {
    public static void main(String[] args) {
        int[] weight = {3, 2, 4, 7 }; //物品的质量
        int[] value = {5, 6, 3, 19};//每个物品对应的价值
        int bag = 11;

//        int[] weight = {1,4,3 }; //物品的质量
//        int[] value = {1500,3000,2000};//每个物品对应的价值
//        int bag = 4;
//        int[] weight = {1,3}; //物品的质量
//        int[] value = {1,1};//每个物品对应的价值
//        int bag = 1;

        System.out.println(maxValueRecur(weight, value,0,0, bag));
//        System.out.println(maxValueDp1(weight, value, bag));
//        System.out.println(maxValueDp2(weight, value, bag));
    }

    //暴力递归
    public static int maxValueRecur(int[] weights, int[] values, int i, int alreadyWeight, int bag) {
        if (i == weights.length) {
            return 0;
        }
        int res=maxValueRecur(weights, values, i + 1, alreadyWeight, bag);
        if (alreadyWeight + weights[i] <= bag) {
            return Math.max(
                    res,
                    values[i] + maxValueRecur(weights, values, i + 1, alreadyWeight + weights[i], bag));
        }

        return res;
    }

    //左神动态规划
    public static int maxValueDp1(int[] weight, int[] value, int bag) {
        int[][] dp = new int[weight.length + 1][bag + 1];
        for (int i = weight.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + weight[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], value[i] + dp[i + 1][j + weight[i]]);
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[0][0];
    }


    //韩老师动态规划
    public static int maxValueDp2(int[] weight, int[] value, int bag) {
        //创建动态规划的二维数组
        int[][] dp = new int[weight.length + 1][bag + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >=weight[i-1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j-weight[i-1]] + value[i-1]);
                }
            }

        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[weight.length][bag];
    }

}
