package com.lingjian.leetcode;

/**
 * @description: 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *               数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]
 *               搜索一个给定的目标值
 *               如果数组中存在这个目标值
 *               则返回它的索引，否则返回 -1 
 *               你可以假设数组中不存在重复的元素
 *               你的算法时间复杂度必须是O(log n)级别
 * @author: Ling Jian
 * @date: 2020-07-21 18:59
 **/
public class Test_33 {
    public static void main(String[] args) {
        int[] nums=new int[]{4,5,6,7,0,1,2};
        int target=7;
        int res = search(nums, target);
        System.out.println(res);

    }

    public static int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return 0;
        }
        return process(nums, 0, nums.length - 1, target);
    }

    public static int process(int[] nums, int left, int right, int k) {
        if(left>right){
            return -1;
        }
        int mid = left + ((right - left) >> 1);
        if(nums[mid]==k){
            return mid;
        }
        if(nums[mid]>=nums[left]){
            if(k>=nums[left]&&k<nums[mid]){
                return process(nums, left, mid - 1, k);
            }else{
                return process(nums, mid + 1, right, k);
            }
        }else{
            if(k<=nums[right]&&k>nums[mid]){
                return process(nums, mid + 1, right, k);
            }else{
                return process(nums, left, mid - 1, k);
            }
        }
    }
}
