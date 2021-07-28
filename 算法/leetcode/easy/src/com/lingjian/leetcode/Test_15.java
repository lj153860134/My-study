package com.lingjian.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给你一个包含 n 个整数的数组nums，
 *               判断nums中是否存在三个元素 a，b，c
 *               使得a + b + c = 0
 *               请你找出所有满足条件且不重复的三元组。
 * @author: Ling Jian
 * @date: 2020-06-12 16:35
 **/
public class Test_15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0};
        List<List<Integer>> list=threeSum(nums);
        System.out.println(Arrays.toString(list.toArray()));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i++) {
            //后面不会产生=0的结果
            if(nums[i]>0){
                break;
            }
            //去重
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while(L <R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    //去重
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    R--;
                    L++;  //这里写一个 写两个都行
                } else if (sum > 0) {
                    R--;
                } else {
                    L++;
                }
            }

        }
        return res;
    }

    //练习用
    public static List<List<Integer>> threeSum1(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length<3){
            return null;
        }
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i++) {
            if(i>0&&nums[i]==nums[i-1]) continue;
            int L=i+1;
            int R=nums.length-1;
            while(L<R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum==0){
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while(L<R&&nums[R]==nums[R-1]){
                        R--;
                    }
                    while(L<R&&nums[L]==nums[L+1]){
                        L++;
                    }
                    L++;
                    R--;

                }else if(sum>0){
                    R--;
                }else{
                    L++;
                }
            }
        }
        return res;
    }

}
