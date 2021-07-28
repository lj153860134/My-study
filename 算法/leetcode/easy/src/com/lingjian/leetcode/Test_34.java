package com.lingjian.leetcode;

import java.util.Arrays;

/**
 * @description: 给定一个按照升序排列的整数数组nums
 *               和一个目标值 target
 *               找出给定目标值在数组中的开始位置和结束位置
 *               你的算法时间复杂度必须是O(log n)级别
 *               如果数组中不存在目标值，返回 [-1, -1]
 * @author: Ling Jian
 * @date: 2020-08-10 10:38
 **/
public class Test_34 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 6;
        int[] res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));

    }

    public static int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return new int[]{-1, -1};
        }
        return process(nums, target, 0, nums.length - 1);
    }

    public static int[] process(int[] nums,int k,int l, int r){
        if (l > r) {

            return new int[] {-1,-1};
        }
        int m=l+((r-l)>>1);
        int[] res = new int[2];
        if(nums[m]==k){
            int index=m;
            while(index<nums.length&&nums[index]==k){
                index++;
            }
            while(m>=0&&nums[m]==k){
                m--;
            }
            res[0] = m+1;
            res[1] = index-1;
            return res;

        }else if(nums[m]<k){
            return process(nums, k, m + 1, r);
        }else{
            return process(nums, k, l, m - 1);
        }
    }
}
