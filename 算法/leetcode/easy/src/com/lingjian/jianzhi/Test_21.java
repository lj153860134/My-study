package com.lingjian.jianzhi;

import java.util.Arrays;

/**
 * @description: 输入一个整数数组，
 *               实现一个函数来调整该数组中数字的顺序
 *               使得所有奇数位于数组的前半部分
 *               所有偶数位于数组的后半部分
 * @author: Ling Jian
 * @date: 2020-06-22 17:07
 **/
public class Test_21 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4,5};
        System.out.println(Arrays.toString(nums));
        nums = exchange(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static int[] exchange(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int L = 0;
        int R = nums.length - 1;
        while (L < R){
            if((nums[L]&1)==0){

                swap(nums,L,R--);
            }else{
                L++;
            }
        }
        return nums;

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
