package com.lingjian.leetcode;

import java.util.Arrays;

/**
 * @description: 给两个整数数组A和B
 *               返回两个数组中公共的
 *               长度最长的子数组的长度
 * @author: Ling Jian
 * @date: 2020-07-01 16:01
 **/
public class Test_718 {
    public static void main(String[] args) {
        int[] A=new int[]{1,2,3,2,1};
        int[] B=new int[]{3,2,1,4,7};
        int res = findLength(A, B);
        System.out.println(res);
    }

    public static int findLength(int[] A, int[] B) {
        int res=0;
        int[][] dp=new int[A.length+1][B.length+1];

        for(int i=1;i<=A.length;i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        for (int i = 0; i <A.length+1 ; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return res;
    }
}
