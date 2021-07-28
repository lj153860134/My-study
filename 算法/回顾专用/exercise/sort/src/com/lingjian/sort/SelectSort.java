package com.lingjian.sort;

import java.util.Arrays;
import java.util.Calendar;

/**
 * @description: 选择排序
 * @author: Ling Jian
 * @date: 2020-05-08 16:52
 **/
public class SelectSort {


    public static void sort(int[] arr) {
        if(arr==null||arr.length<2){
            return;
        }
        for (int i = 0; i <arr.length-1 ; i++) {
            int minIndex=i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex=j;
                }
            }
            if(minIndex!=i) {
                swap(arr, i, minIndex);
            }
        }

    }


    private static void swap(int[] arr, int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }
}
