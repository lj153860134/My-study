package com.lingjian.leetcode;

/**
 * @description: 给定一个非负整数数组
 * 你最初位于数组的第一个位置
 * 数组中的每个元素
 * 代表你在该位置可以跳跃的最大长度
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * @author: Ling Jian
 * @date: 2020-07-31 21:14
 **/
public class Test_45 {
    public static void main(String[] args) {

    }

    //dp+贪心
    public static int jump(int[] nums) {
        int n = nums.length;
        if (n < 1) return 0;
        int[] dp = new int[n + 1];
        for (int i = 2, j = 1; i <= n; i ++) {
            while (j + nums[j - 1] < i) j ++;
            dp[i] = dp[j] + 1;
        }
        return dp[n];

    }


    public static int jump2(int[] nums) {
        int n = nums.length;
        if (n < 1) return 0;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j<i ; j++) {
                if(nums[j-1]+j>=i){
                    dp[i] = dp[j] + 1;
                    break;
                }
            }

        }
        return dp[n];

    }


    //贪心
    public static int jump1(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) { //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;


    }
}
