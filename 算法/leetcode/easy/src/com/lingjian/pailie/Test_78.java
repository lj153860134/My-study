package com.lingjian.pailie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 给定一组不含重复元素的整数数组nums
 *                返回该数组所有可能的子集（幂集）
 *                说明：解集不能包含重复的子集。
 * @author: Ling Jian
 * @date: 2020-08-26 09:38
 **/
public class Test_78 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> ans = subsets(nums);
        System.out.println(Arrays.toString(ans.toArray()));

     }

    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        if(nums==null){
            return res;
        }
        LinkedList<Integer> list = new LinkedList<>();
        dfs(nums, 0, list);
        return res;
    }

    public static void dfs(int[] nums,int start,LinkedList<Integer> list){
        res.add(new ArrayList<>(list));
        for (int i = start; i <nums.length ; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, list);
            list.pollLast();
        }
    }
}
