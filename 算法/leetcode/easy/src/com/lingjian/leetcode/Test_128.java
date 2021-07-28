package com.lingjian.leetcode;

import java.util.HashSet;

/**
 * @description: 给定一个未排序的整数数组
 *               找出最长连续序列的长度
 *               要求算法的时间复杂度为 O(n)
 * @author: Ling Jian
 * @date: 2020-07-31 09:16
 **/
public class Test_128 {
    public static void main(String[] args) {
        int[] nums=new int[]{100, 4, 200, 1, 3, 2};
        int res = longestConsecutive(nums);
        int res1 = longestConsecutive1(nums);
        System.out.println(res);
        System.out.println(res1);
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int res = 1;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(++num)) {
                    count++;
                }
                res = Math.max(count, res);
            }
        }
        return res;
    }

    //练习专用
    public static int longestConsecutive1(int[] nums) {

        if(nums==null||nums.length==0){
            return -1;
        }
        if(nums.length==1){
            return 1;
        }
        int res=1;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (Integer i : set) {
            if(!set.contains(i-1)){
                int count=0;
                while(set.contains(i++)){
                    count++;
                }
                res = Math.max(count, res);
            }
        }
        return res;
    }

}
