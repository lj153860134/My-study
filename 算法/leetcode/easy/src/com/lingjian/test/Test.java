package com.lingjian.test;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;

/**
 * @description: 测试专用
 * @author: Ling Jian
 * @date: 2020-06-11 15:17
 **/
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(nums));
        int k = 5;
        reverseKth(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverseKth(int[] nums,int k){
        reverse(nums, 0, nums.length-1-k);
        reverse(nums, nums.length-k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public static void reverse(int[] nums,int i,int j){
        while(i<j){
            swap(nums, i++, j--);
        }
    }


    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}








