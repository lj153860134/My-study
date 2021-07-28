package com.lingjian.sort;

import java.util.Arrays;

/**
 * @description: 快速排序
 * @author: Ling Jian
 * @date: 2020-05-08 18:23
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 5, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quick(arr,0,arr.length-1);
    }

    private static void quick(int[] arr, int left, int right) {
        if(left>=right){  //这里>=很关键 不能用=
            return;
        }
        int less=left-1;
        int more=right+1;
        int num = arr[left+(int) ((right - left + 1) * Math.random())];
        int cur = left;
        while (cur < more) {
            if (arr[cur] < num) {
                swap(arr,++less,cur++);
            } else if (arr[cur] > num) {
                swap(arr, --more, cur);
            }else{
                cur++;
            }
        }
        quick(arr, left, less);
        quick(arr, more, right);
    }


    private static void swap(int[] arr, int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }


}
