package com.lingjian.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 给定一个可能包含重复元素的整数数组nums
 *               返回该数组所有可能的子集（幂集）
 *               说明：解集不能包含重复的子集。
 * @author: Ling Jian
 * @date: 2020-08-25 19:51
 **/
public class Test_90 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> res = subsets(nums);
        System.out.println(Arrays.toString(res.toArray()));

    }
    static List<List<Integer>> res=new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> list=new LinkedList<>();

        Arrays.sort(nums);//去重的话 要排序的
        dfs1(nums,0,list);
        return res;
    }


    //第二种
    public static void dfs1(int[] nums, int start, LinkedList<Integer> list){

            res.add(new ArrayList<>(list));

        for (int i = start; i <nums.length ; i++) {
            if(i > start &&nums[i]==nums[i -1]){
                continue;
            }
            list.add(nums[i]);
            dfs1(nums, i + 1, list);
            list.pollLast();
        }
    }


}
