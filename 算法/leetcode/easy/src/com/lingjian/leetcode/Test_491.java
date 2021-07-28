package com.lingjian.leetcode;

import java.util.*;

/**
 * @description: 给定一个整型数组
 * 你的任务是找到所有该数组的递增子序列
 * 递增子序列的长度至少是2。
 * @author: Ling Jian
 * @date: 2020-08-25 09:48
 **/
public class Test_491 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 7, 7, 7,8};
        List<List<Integer>> haha = findSubsequences(nums);
        System.out.println(Arrays.toString(haha.toArray()));

    }

    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> list = new LinkedList<>();
    public static List<List<Integer>> findSubsequences(int[] nums) {

        dfs(nums, 0, Integer.MIN_VALUE);
        return res;
    }

    public static void dfs(int[] nums, int i,int last) {
        if (i == nums.length) {
            if (list.size() >= 2) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        if(nums[i]>=last){
            list.add(nums[i]);
            dfs(nums,i+1,nums[i]);
            list.pollLast();
        }
        if(nums[i]!=last){
            dfs(nums, i + 1, last);
        }


    }
}
