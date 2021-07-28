package com.lingjian.leetcode;

/**
 * @description: 给定一个整数数组nums
 *               找到一个具有最大和的连续子数
 *               （子数组最少包含一个元素）
 *                返回其最大和
 * @author: Ling Jian
 * @date: 2020-07-22 16:51
 **/
public class Test_53 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, -1, -3};
        int res = maxSubArray(nums);
        System.out.println(res);
    }


    //贪心
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int res = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            if(sum>0){
                sum += nums[i];
            }else{
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    //动态规划
    public static int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length+1];
        int res = nums[0];
        for (int i = 1; i <dp.length ; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
