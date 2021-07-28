package com.lingjian.leetcode;

/**
 * @description: 给定一个非负整数数组
 *              你最初位于数组的第一个位置
 *              数组中的每个元素代表你在该位置可以跳跃的最大长度
 *              判断你是否能够到达最后一个位置。
 * @author: Ling Jian
 * @date: 2020-07-31 20:37
 **/
public class Test_55 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 3};
        boolean res1 = canJump(nums);
        boolean res2 = canJump1(nums);
        System.out.println(res1);
        System.out.println(res2);

    }
    //贪心
    public static boolean canJump(int[] nums) {
        int can_reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > can_reach) return false;
            can_reach = Math.max(can_reach, i + nums[i]);
        }
        return true;
    }

    //dp
    public static boolean canJump1(int[] nums){
        boolean[] dp=new boolean[nums.length+1];
        dp[0]=true;
        dp[1]=true;
        for (int i = 2; i <dp.length ; i++) {
            for (int j = 1; j<i ; j++) {
                if(nums[j-1]+j>=i){
                    dp[i]=dp[j];
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }

}
