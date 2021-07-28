package com.lingjian.leetcode;

import java.util.Arrays;

/**
 * @description: 实现获取下一个排列的函数
 * 算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列
 * 则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * @author: Ling Jian
 * @date: 2020-09-14 16:49
 **/
public class Test_31 {
    public static void main(String[] args) {
        int[] nums = new int[]{100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void nextPermutation(int[] nums) {
        if(nums==null||nums.length<=1){
            return;
        }
        int r = nums.length - 1;
        while(r-1>=0&&nums[r-1]>=nums[r]){
            r--;
        }
        if(r==0){
            int mid = nums.length / 2;
            for (int i = 0; i <mid ; i++) {
                swap(nums, i, nums.length - 1 - i);

            }
            return;
        }
        int p = nums.length - 1;
        while(p>=r){
            if(nums[p]>nums[r-1]) break;
            p--;
        }
        swap(nums, p, r - 1);
        int temp = (nums.length - r) / 2;
        for (int i = r; i <r+temp ; i++) {
            swap(nums, i, nums.length - i+r-1);
        }
    }

    public static void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
