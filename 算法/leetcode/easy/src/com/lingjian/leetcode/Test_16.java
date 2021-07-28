package com.lingjian.leetcode;

import java.util.Arrays;

/**
 * @description: 给定一个包括n个整数的数组nums
 *               和一个目标值target
 *               找出nums中的三个整数
 *               使得它们的和与target最接近返回这三个数的和
 *               假定每组输入只存在唯一答案。
 * @author: Ling Jian
 * @date: 2020-08-04 22:11
 **/
public class Test_16 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,10,11};
        int target = 12;
        int res = threeSumClosest(nums, target);
        System.out.println(res);
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int gap = Integer.MAX_VALUE;
        for (int i = 0; i <nums.length ; i++) {

            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int L=i+1;
            int R=nums.length-1;
            while(L<R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum==target){
                    return target;
                }else if(sum>target){
                    res = sum - target < gap ? sum : res;
                    gap = sum - target < gap ? sum - target : gap;
                    R--;
                }else{
                    res = target - sum < gap ? sum : res;
                    gap = target - sum < gap ? target - sum : gap;
                    L++;
                }
            }

        }
        return res;
    }
}
