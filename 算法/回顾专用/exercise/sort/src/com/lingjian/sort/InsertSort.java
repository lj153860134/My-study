package com.lingjian.sort;

/**
 * @description: 插入排序
 * @author: Ling Jian
 * @date: 2020-05-08 17:24
 **/
public class InsertSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length <2) {
            return;
        }

        for (int i = 1; i <arr.length ; i++) {
            int insertVal = arr[i];
            int insertIndex=i-1;
            if (arr[insertIndex] > insertVal) {
                while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                    arr[insertIndex + 1] = arr[insertIndex];
                    insertIndex--;
                }
            }
            if (insertIndex != i - 1) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

}
