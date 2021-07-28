package com.lingjian.jianzhi;

import java.util.HashSet;

/**
 * @description: 输入一个递增排序的数组和一个数字s
 *               在数组中查找两个数，使得它们的和正好是s
 *               如果有多对数字的和等于s，则输出任意一对即可
 * @author: Ling Jian
 * @date: 2020-07-06 16:31
 **/
public class Test_57 {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        if(nums.length==1){
            return null;
        }
        HashSet<Integer> set=new HashSet<>();
        int[] res=new int[2];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>target){
                break;
            }
            if(set.contains(target-nums[i])){
                res[0]=target-nums[i];
                res[1]=nums[i];
                return res;
            }else{
                set.add(nums[i]);
            }
        }
        return null;
    }
}
