package com.lingjian.leetcode;
import java.util.Arrays;

/**
 * @description: 给定一个无序的整数数组
 *               找到其中最长上升子序列的长度。
 * @author: Ling Jian
 * @date: 2020-08-25 00:48
 **/
public class Test_300 {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        int max=0;
        for (int i = 2; i <dp.length ; i++) {
            for (int j = 1; j <i ; j++) {
                if(nums[i-1]>nums[j-1]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    //二分解法
    public int lengthOfLIS1(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }

}
