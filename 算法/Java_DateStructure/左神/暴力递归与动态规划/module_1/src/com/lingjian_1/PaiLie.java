package com.lingjian_1;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @description: 排列组合
 * @author: Ling Jian
 * @date: 2020-07-24 10:58
 **/
public class PaiLie {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        //全排列
//        f1(nums, 3, 0);
//        System.out.println(Arrays.toString(res.toArray()));
//        System.out.println(res.size());
        //排列组合
        f2(nums, 3, 0);
        System.out.println(Arrays.toString(res.toArray()));
        System.out.println(res.size());
        //选择排列组合
//        f3(nums, 2, 0, 0);
//        System.out.println(Arrays.toString(res.toArray()));
//        System.out.println(res.size());
    }

    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> list = new LinkedList<>();

    /**
     *
     * @param nums   待选择的数组
     * @param count  要选择多少个次
     * @param cur   当前选择的是第几次
     */
    public static void f1(int[] nums, int count, int cur) {

        if (cur == count) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            list.addLast(nums[i]);
            f1(nums, count, cur + 1);
            list.pollLast();
        }
    }

    /**
     *
     * @param nums   待选择的数组
     * @param count  要选择多少个次
     * @param cur   当前选择的是第几次
     */

    public static void f2(int[] nums, int count, int cur) {

        if (cur == count) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.addLast(nums[i]);
                f2(nums, count, cur + 1);
                list.pollLast();
            }
        }
    }

    /**
     *
     * @param nums   待选择的数组
     * @param count  一共要选择多少个次
     * @param cur    当前选到的下标
     * @param has    当前有多少元素
     */

    public static void f3(int[] nums,int count,int has,int cur){
        if (has == count) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = cur; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.addLast(nums[i]);
                f3(nums, count, has + 1, i);
                list.pollLast();
            }
        }
    }


}
