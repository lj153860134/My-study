package com.lingjian.jianzhi;

/**
 * @description: 输入一个整型数组
 *               数组里有正数也有负数
 *               数组中的一个或连续多个整数组成一个子数组
 *               求所有子数组的和的最大值
 * @author: Ling Jian
 * @date: 2020-07-01 18:48
 **/
public class Test_42 {
    public static void main(String[] args) {
        int[] nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(nums);
        int res1 = maxSubArray1(nums);
        System.out.println(res);
        System.out.println(res1);

    }


    //动态规划
    public static int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0) {
            return 0;
        }
            if(nums.length==1){
            return nums[0];
        }
        int res = Integer.MIN_VALUE;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i <dp.length ; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    //贪心算法
    public static int maxSubArray1(int[] nums){
        int sum=0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            sum = sum <= 0 ? nums[i] : sum + nums[i];
            res = Math.max(res, sum);
        }
        return res;
    }
}
