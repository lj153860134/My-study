package com.lingjian.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目
 * @author: Ling Jian
 * @date: 2020-06-03 17:29
 **/
public class Test_1431 {
    public static void main(String[] args) {
        int[] candies=new int[]{4,2,1,1,2};
        int extraCandies = 1;
        List<Boolean> res = kidsWithCandies(candies, extraCandies);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <candies.length ; i++) {
            max = Math.max(max, candies[i]);
        }
        for (int i = 0; i <candies.length ; i++) {
            if (candies[i] + extraCandies >= max) {
                list.add(true);
            }else{
                list.add(false);
            }
        }
        return list;


    }
}
