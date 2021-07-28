package com.lingjian.pailie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 给定一个 没有重复 数字的序列，返回其所有可能的全排列
 * @author: Ling Jian
 * @date: 2020-06-15 18:07
 **/
public class Test_46 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3};
        List<List<Integer>> list = permute(nums);
        System.out.println(Arrays.toString(list.toArray()));
        List<List<Integer>> list1 = permute1(nums);
        System.out.println(Arrays.toString(list1.toArray()));
        List<List<Integer>> list2 = permute2(nums);
        System.out.println(Arrays.toString(list2.toArray()));
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
    public static List<List<Integer>> permute1(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        process1(nums, list);
        return res1;
    }

    public static void process1(int[] nums,LinkedList<Integer> list){
        if(nums.length==list.size()){
            res1.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i <nums.length ; i++) {
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            process1(nums, list);
            list.removeLast();
        }
    }



    //模板套路（中间的i可以不用了） 同上题解法
    static List<List<Integer>> res2 = new ArrayList<>();
    public static List<List<Integer>> permute2(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        dfs(nums, 0,list);
        return res2;
    }

    public static void dfs(int[] nums,int start,LinkedList<Integer> list){
        if(list.size()==nums.length){
            res2.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i <nums.length ; i++) {
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs(nums, i + 1, list);
            list.pollLast();
        }
    }




}
