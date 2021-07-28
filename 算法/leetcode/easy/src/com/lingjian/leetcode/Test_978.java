package com.lingjian.leetcode;

import java.util.Arrays;

/**
 * @description: 当 A 的子数组 A[i], A[i+1], ..., A[j]
 *               满足下列条件时，我们称其为湍流子数组
 *               若 i <= k < j，当 k 为奇数时，
 *               A[k] > A[k+1]，且当 k 为偶数时
 *               A[k] < A[k+1]；
 *               或 若 i <= k < j，当 k 为偶数时
 *               A[k] > A[k+1] ，且当 k 为奇数时，
 *               A[k] < A[k+1]。
 *               也就是说，
 *               如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。  返回 A 的最大湍流子数组的长度。
 * @author: Ling Jian
 * @date: 2020-09-03 16:28
 **/
public class Test_978 {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};
        int res = maxTurbulenceSize(nums);
        System.out.println(res);
    }
    public static int maxTurbulenceSize(int[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        if(A.length==1){
            return 1;
        }
        int res=0;
        //dp[i][0]表示以第i个数结尾 大于前一个数的最长湍流
        //dp[i][1]表示以第i个数结尾 小于前一个数的最长湍流
        int[][] dp = new int[A.length + 1][2];
        dp[1][0]=1;
        dp[1][1]=1;
        for (int i = 2; i <dp.length ; i++) {
            dp[i][0] = A[i - 1] > A[i - 2] ? dp[i-1][1] + 1 : 1;
            dp[i][1] = A[i - 1] < A[i - 2] ? dp[i-1][0] + 1 : 1;
            int max = Math.max(dp[i][0], dp[i][1]);
            res = Math.max(max, res);
        }
        for (int i = 0; i <dp.length ; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return res;
    }
}
