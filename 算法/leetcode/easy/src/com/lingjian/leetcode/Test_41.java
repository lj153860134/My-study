package com.lingjian.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description: 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数
 * @author: Ling Jian
 * @date: 2020-06-16 14:32
 **/
public class Test_41 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,2,2,1,1,4,2,5,7};
        int res = firstMissingPositive1(nums);
        int res1 = firstMissingPositive2(nums);
        System.out.println(res);
        System.out.println(res1);

    }


    //用hashSet 但是空间复杂度O(n)
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return nums.length + 1;
    }
    
    //最优解 将该数组当成一个hash表
    public static int firstMissingPositive1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
//        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }

    //练习版
    public static int firstMissingPositive2(int[] nums){
        if(nums==null||nums.length==0){
            return 0;
        }
        for (int i = 0; i <nums.length ; i++) {
            while(nums[i]>0&&nums[i]<nums.length&&nums[nums[i]-1]!=nums[i]){
                swap(nums,nums[i]-1,i);
            }
        }
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]!=i+1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    

}
