package com.lingjian.exercise;

import java.util.Arrays;

/**
 * @description: 数组交换  语句倒装
 * @author: Ling Jian
 * @date: 2020-09-14 10:36
 **/
public class ChangeArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(nums));
        int k = 5;
        reverseKth(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverseKth(int[] nums,int k){
        reverse(nums, 0, nums.length-1-k);
        reverse(nums, nums.length-k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public static void reverse(int[] nums,int i,int j){
        while(i<j){
            swap(nums, i++, j--);
        }
    }


    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
