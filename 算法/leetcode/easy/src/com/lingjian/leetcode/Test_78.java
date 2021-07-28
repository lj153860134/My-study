package com.lingjian.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 给定一组不含重复元素的整数数组nums
 *               返回该数组所有可能的子集（幂集）
 *               说明：解集不能包含重复的子集。
 * @author: Ling Jian
 * @date: 2020-08-24 22:21
 **/
public class Test_78 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        System.out.println(Arrays.toString(res.toArray()));

    }
    static List<List<Integer>> res=new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> list=new LinkedList<>();
//        dfs(nums,0,list);
        dfs1(nums,0,list);
        return res;
    }
    //第一种
    public static void dfs(int[] nums,int i,LinkedList<Integer> list){
        if(i==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        dfs(nums,i+1,list);
        list.pollLast();
        dfs(nums,i+1,list);
    }

    //第二种
    public static void dfs1(int[] nums,int start,LinkedList<Integer> list){
                res.add(new ArrayList<>(list));

        for (int i = start; i <nums.length ; i++) {
            list.add(nums[i]);
            dfs1(nums, i + 1, list);
            list.pollLast();
        }
    }
}
