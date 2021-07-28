package com.lingjian.leetcode;

/**
 * @description: 我们将给定的数组A分成K个相邻的非空子数组
 *               我们的分数由每个子数组内的平均值的总和构成
 *               计算我们所能得到的最大分数是多少
 *               注意我们必须使用A数组中的每一个数进行分组
 *               并且分数不一定需要是整数
 * @author: Ling Jian
 * @date: 2020-07-24 16:57
 **/
public class Test_813 {
    public static void main(String[] args) {

    }

    //dp[i][j]代表数组中前i个数 分成j组 最大平均总和
    public static double largestSumOfAverages(int[] A, int K) {
        double [][] dp = new double [A.length + 1][K + 1];
        double[] sum = new double[A.length+1];
        for (int i = 1; i <A.length+1 ; i++) {
            sum[i] += A[i-1] + sum[i - 1];
        }
        for (int i = 0; i <A.length+1 ; i++) {
            dp[i][1] = sum[i]/i;
        }
        for (int i = 2; i <A.length+1 ; i++) {
            for (int j = 2; j <K+1 ; j++) {
                for (int k = 1; k < i-j+2; k++) {
                    dp[i][j]=Math.max(dp[i][j],dp[i-k][j-1]+(sum[i]-sum[i-k])/k);
                }
            }
        }
        return dp[A.length][K];

    }
}
