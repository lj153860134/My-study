package com.lingjian.leetcode;

/**
 * @description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置
 * @author: Ling Jian
 * @date: 2020-06-02 15:06
 **/
public class Test_35 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3};
        int target = 2;
        int res1 = searchInsert1(nums, target);
//        int res2 = searchInsert2(nums, target);
        System.out.println(res1);
//        System.out.println(res2);
    }


    //递归版本
    public static int searchInsert1(int[] nums, int target) {
        if (nums.length < 1) {
            return 0;
        }
//        if (nums[nums.length - 1] < target) {
//            return nums.length;
//        }
        return process(nums, target, 0, nums.length - 1);

    }

    //套路二分法
    public static int process(int[] nums, int target, int left, int right) {
        if (left > right) {
            return left;
        }
        int mid = ((left + right) >> 1);
        if (nums[mid] == target) {
            return mid;
        } else {
            return nums[mid] > target ? process(nums, target, left, mid-1) :
                    process(nums, target, mid + 1, right);
        }
    }


    //非递归版本
    public  static int searchInsert2(int[] nums, int target) {
        int left=0;
        int right = nums.length - 1;
        while (left < right) {
            int mid=((left + right) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid]> target) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return nums[left] < target ? left + 1 : left;
    }


}
