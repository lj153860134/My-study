package com.lingjian_1;

import java.util.Arrays;

/**
 * @description: 归并排序
 * @author: Ling Jian
 * @date: 2019-12-09 10:54
 **/
public class MergeSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 4, 5, 6, 7};
        System.out.print("归并排序前:");
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("--------");
        System.out.print("归并排序后:");
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        setProcess(arr, 0, arr.length - 1); //递归过程
    }

    private static void setProcess(int[] arr, int left, int right) {
        if (left == right) {  //递归结束条件
            return;
        }
        //获取中间的索引
        int mid = left + ((right - left) >> 1);  //这里位运算后面的括号一定要加
                                                 //不然会报错
        //左边排序
        setProcess(arr, left, mid);
        //右边排序
        setProcess(arr, mid + 1, right);
        //合并左边和右边 使整体有序
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        //辅助数组 帮助排序
        int[] help = new int[right - left + 1];
        int p1 = left;   //左侧数组的索引
        int p2 = mid + 1;//右侧数组的索引

        int p = 0; //辅助数组的索引

        while (p1 <= mid && p2 <= right) {
            if (arr[p1] <arr[p2]) {
                help[p++] = arr[p1++];
            } else {
                help[p++] = arr[p2++];
            }
        }

//        for (int i = p1; i <= mid; i++) {
//            help[p++] = arr[i];
//        }
//
//        for (int i = p2; i <= right; i++) {
//            help[p++] = arr[i];
//        }

        //p1 p2 两个有且只有一个越界
        while(p1<=mid){
            help[p++]=arr[p1++];
        }

        while(p2<=right){
            help[p++]=arr[p2++];
        }
        //将有序的辅助数组 复制到原数组中
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }

        
    }


}
