package com.lingjian.sort;

/**
 * @description: 归并排序
 * @author: Ling Jian
 * @date: 2020-05-08 18:59
 **/
public class MergeSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        setProcess(arr,0,arr.length-1);

    }

    private static void setProcess(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = left + ((right - left) >> 1);
        setProcess(arr, left, mid);
        setProcess(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p1=left;
        int p2 = mid + 1;
        int p=0;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] <= arr[p2]) {
                help[p++] = arr[p1++];
            }else{
                help[p++] = arr[p2++];
            }
        }

        while (p1 <= mid) {
            help[p++] = arr[p1++];
        }

        while (p2 <= right) {
            help[p++] = arr[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }


    
    
}
