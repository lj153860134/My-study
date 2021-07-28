package com.lingjian.leetcode;

import java.util.*;

/**
 * @description: 给定一个 没有重复 数字的序列，返回其所有可能的全排列
 * @author: Ling Jian
 * @date: 2020-06-15 18:07
 **/
public class Test_46 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3};
        List<List<Integer>> list = permute1(nums);
        System.out.println(Arrays.toString(list.toArray()));
    }

    //不用辅助空间 时间复杂度更低一些
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        process(nums, 0);
        return res;
    }

    private static void process(int[] nums, int i) {
        if (i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
        }
        for (int j = i; j <nums.length ; j++) {
            swap(nums, i, j);
            //这里不需要copy
//            int[] temp = Arrays.copyOf(nums, nums.length);
            process(nums, i + 1);
            swap(nums, i, j);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    //用一个额外的辅助空间
    static List<List<Integer>> res1 = new ArrayList<>();
    static LinkedList<Integer> list = new LinkedList<>();
    public static List<List<Integer>> permute1(int[] nums) {

        process1(nums);
        return res1;
    }

    public static void process1(int[] nums){
        if(nums.length==list.size()){
            res1.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i <nums.length ; i++) {
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            process1(nums);
            list.pollLast();
        }
    }




}
