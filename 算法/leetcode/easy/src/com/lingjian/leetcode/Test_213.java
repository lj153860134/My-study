package com.lingjian.leetcode;

import java.util.Arrays;

/**
 * @description: 你是一个专业的小偷
 *               计划偷窃沿街的房屋
 *               每间房内都藏有一定的现金
 *               这个地方所有的房屋都围成一圈
 *               这意味着第一个房屋和最后一个房屋是紧挨着的
 *               同时，相邻的房屋装有相互连通的防盗系统
 *               如果两间相邻的房屋在同一晚上被小偷闯入
 *               系统会自动报警
 *               给定一个代表每个房屋存放金额的非负整数数组
 *               计算你在不触动警报装置的情况下
 *               能够偷窃到的最高金额。
 * @author: Ling Jian
 * @date: 2020-07-31 19:40
 **/
public class Test_213 {
    public static void main(String[] args) {

    }
    public static int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        Arrays.copyOf(nums, 0);
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    private static int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }


}
