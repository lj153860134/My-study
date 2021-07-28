package com.lingjian.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 给定一个包含非负数的数组和一个目标整数k
 *               编写一个函数来判断该数组是否含有连续的子数组
 *               其大小至少为2且总和为k的倍数
 *               即总和为 n*k，其中 n 也是一个整数
 * @author: Ling Jian
 * @date: 2020-05-26 15:12
 **/
public class Test_523 {
    public static void main(String[] args) {
        int[] arr=new int[]{0,1,0};
        int aim=-1;
        boolean res=checkSubarraySum( arr, aim);
        System.out.println(res);
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(); // 键为 preSum % k, 值为索引，当然要特殊处理k == 0的情况
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int temp = k == 0 ? sum : sum % k;
            if(map.containsKey(temp)){ // 出现相同的键，如果子数组长度少于2， 不需要更新值。
                if(i - map.get(temp) > 1) // 子数组要求长度至少为2。
                    return true;
                continue;
            }
            map.put(temp, i);
        }
        return false;
    }

}
