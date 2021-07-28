package com.lingjian.jianzhi;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @description: 找出数组中重复的数字
 *               在一个长度为n的数组nums里的所有数字都在 0～n-1 的范围内
 *               数组中某些数字是重复的
 *               但不知道有几个数字重复了，
 *               也不知道每个数字重复了几次。
 *               请找出数组中任意一个重复的数字
 * @author: Ling Jian
 * @date: 2020-06-20 16:22
 **/
public class Test_03 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
        System.out.println(findRepeatNumber1(nums));
        System.out.println(findRepeatNumber2(nums));

    }

    //用hashSet
    public static int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }

        return -1;

    }

    //排序
    public static int findRepeatNumber1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]==nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }

    //交换
    public static int findRepeatNumber2(int[] nums) {
        for (int i = 0; i <nums.length ; i++) {
            while(nums[i]!=i){
              if(nums[nums[i]]!=nums[i]){
                  swap(nums,nums[i],i);
              }else{
                  return nums[i];
              }
            }
        }
        return -1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
