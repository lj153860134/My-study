package com.lingjian.leetcode;

/**
 * @description: 峰值元素是指其值大于左右相邻值的元素。
 *               给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]
 *               找到峰值元素并返回其索引。
 *               数组可能包含多个峰值
 *               在这种情况下，返回任何一个峰值所在位置即可
 *               你可以假设 nums[-1] = nums[n] = -∞
 * @author: Ling Jian
 * @date: 2020-08-05 20:15
 **/
public class Test_162 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        int res = findPeakElement(nums);
        System.out.println(res);

    }

    public static int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        return process(nums,0,nums.length-1);
    }

    public static int process(int[] nums,int left,int right){
        if(left>right){
            return left;
        }
        int mid=left+((right-left)>>1);
        if(mid==nums.length-1){
            return nums.length - 1;
        }
        if(nums[mid]<nums[mid+1]){
            return process(nums,mid+1,right);
        }else{
            return process(nums,left,mid-1);
        }
    }
}
