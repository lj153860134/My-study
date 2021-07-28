package com.lingjian.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @description: 两数之和给定一个整数数组 nums和一个目标值 target
 *               请你在该数组中找出和为目标值的那两个整数
 *               并返回他们的数组下标。
 *               你可以假设每种输入只会对应一个答案
 *               但是，数组中同一个元素不能使用两遍
 * @author: Ling Jian
 * @date: 2020-03-21 21:47
 **/
public class Test_01 {
    public static void main(String[] args) {
        int [] nums=new int[]{2, 7, 11, 15};
        int target=9;
        int[] res=solution(nums,target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] solution(int[] nums,int target){


        if(nums==null||nums.length<=1){
            return null;
        }
        int[] res=new int[2];
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            int nextValue=target-nums[i];
            if(maps.containsKey(nextValue)){
                res[0]=maps.get(nextValue);
                res[1]=i;
                break;
            }else{
                maps.put(nums[i],i);
            }
        }
        return res;
    }
}
