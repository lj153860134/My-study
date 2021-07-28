package com.lingjian.sort;

import java.util.Arrays;

/**
 * @description: 冒泡排序
 * @author: Ling Jian
 * @date: 2020-05-08 16:23
 **/
public class BubbleSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length <2) {
            return;
        }
        for (int i = 0; i <arr.length-1 ; i++) {
            int count=0; //判断每次冒泡交换的次数 用于优化冒泡算法
            for (int j = 1; j <arr.length-i ; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr,j-1,j);
                    count++;
                }
            }
//            System.out.println(Arrays.toString(arr));
            if (count == 0) {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }
}
