package com.lingjian.leetcode;

import java.util.HashMap;

/**
 * @description: 给定一个含有n个正整数的数组和一个正整数 s
 *               找出该数组中满足其和 ≥ s 的长度最小的连续子数组
 *               并返回其长度 如果不存在符合条件的连续子数组 返回 0
 * @author: Ling Jian
 * @date: 2020-06-28 15:33
 **/
public class Test_209 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,4,4};
        int s = 4;
        int res = minSubArrayLen(s, nums);
        int res1 = minSubArrayLen1(s, nums);
        System.out.println(res);
        System.out.println(res1);
    }

    //双指针
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length<1){
            return 0;
        }
        int L=0;
        int R=0;
        int res=Integer.MAX_VALUE;
        int sum=0;
        while(R<nums.length){
            sum+=nums[R++];
            while(sum>=s){
                res=Math.min(res,R-L);
                sum -= nums[L++];

            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;

    }

    public static int minSubArrayLen1(int s, int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int L=-1;
        int R=-1;
        int res=Integer.MAX_VALUE;
        int sum=0;
        while(R<nums.length-1){
            if(sum<s){
                sum+=nums[++R];
            }else{
                res = Math.min(R - L, res);
                sum -= nums[++L];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;

    }



}
