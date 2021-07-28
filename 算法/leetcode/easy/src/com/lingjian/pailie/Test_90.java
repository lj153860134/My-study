package com.lingjian.pailie;

import java.util.*;

/**
 * @description: 给定一个可能包含重复元素的整数数组nums
 *               返回该数组所有可能的子集（幂集）
 *               说明：解集不能包含重复的子集。
 * @author: Ling Jian
 * @date: 2020-08-26 09:46
 **/
public class Test_90 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> ans = subsets(nums);
        System.out.println(Arrays.toString(ans.toArray()));

    }

    static List<List<Integer>> res = new ArrayList<>();
    //利用set进行去重 但是效率较低
    static Set<List<Integer>> set = new HashSet<>();
    public static List<List<Integer>> subsets(int[] nums) {
        if(nums==null){
            return res;
        }
        LinkedList<Integer> list = new LinkedList<>();
//        dfs(nums, 0, list);
        dfs1(nums, 0, list);
        return res;
    }

    public static void dfs(int[] nums, int start, LinkedList<Integer> list){
        if(!set.contains(new ArrayList<>(list))) {
            res.add(new ArrayList<>(list));
            set.add(new ArrayList<>(list));
        }
        for (int i = start; i <nums.length ; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, list);
            list.pollLast();
        }
    }

    //剪枝判断 效率更高


    public static void dfs1(int[] nums, int start, LinkedList<Integer> list){

            res.add(new ArrayList<>(list));
        for (int i = start; i <nums.length ; i++) {
            if(i>start&&nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            dfs1(nums, i + 1, list);
            list.pollLast();
        }
    }

}
