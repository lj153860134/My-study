package com.lingjian_3;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2019-12-14 10:34
 **/

/*
 * 需求 一个数组 已经排序好之后 求出相邻两个数的最大差值
 *      时间复杂度为O(n)  且不能用基于比较的排序
 */
public class MaxDifferenceDemo {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7,8,10};
        MaxDifference(arr);
    }

    private static void MaxDifference(int[] arr) {
        if(arr==null||arr.length<2) {
            return;
        }
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
        }
        boolean[] flag=new boolean[arr.length+1];
        int[] maxArr=new int[arr.length+1];
        int[] minArr=new int[arr.length+1];



    }
}
