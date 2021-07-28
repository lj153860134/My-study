package com.lingjian.jianzhi;

/**
 * @description: 一个长度为n-1的递增排序数组中的所有数字
 *              都是唯一的，并且每个数字都在范围0～n-1之内
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中
 * 请找出这个数字
 * @author: Ling Jian
 * @date: 2020-07-08 18:00
 **/
public class Test_53_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 3};
        int res = missingNumber1(nums);
        System.out.println(res);

    }

    public static int missingNumber(int[] nums) {
        int res = process(nums, 0, nums.length - 1);
        return res;
    }

    public static int process(int[] nums, int left, int right) {
        if (left > right) {
            return left;
        }
        int mid = left + ((right - left) >> 1);
        if (mid == nums[mid]) {
            return process(nums, mid + 1, right);
        } else {
            return process(nums, left, mid - 1);
        }

    }

    //不能这么做 当nums.length==1 得不到答案
    public static int missingNumber1(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }

        }
        return -1;

    }
}
