package com.lingjian.sort;

/**
 * @description: 希尔排序
 * @author: Ling Jian
 * @date: 2020-05-08 17:50
 **/
public class ShellSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length <2) {
            return;
        }
        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i<arr.length; i++) {
                int insertVal = arr[i];
                int insertIndex=i-gap;
                if (arr[insertIndex] > insertVal) {
                    while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                        arr[insertIndex + gap] = arr[insertIndex];
                        insertIndex-=gap;
                    }
                }
                if (insertIndex != i - gap) {
                    arr[insertIndex + gap] = insertVal;
                }
            }
        }
    }
}
