package com.lingjian_1;

import java.util.Arrays;

/**
 * @description: 检查排序是否正确
 * @author: Ling Jian
 * @date: 2019-12-11 11:35
 **/
public class Test {

    public static void main(String[] args) {

        int testTime = 100000;
        int maxSize = 100;
        int maxValue = 100;
        boolean flag = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generatorRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
//            BubbleSortDemo.bubbleSort(arr1);    //冒泡排序
//            InsertSortDemo.insertSort(arr1);    //插入排序
//            MergeSortDemo.mergeSort(arr1);      //归并排序
//            QuickSortDemo.quickSort2(arr1);  //快速排序
//            SelectSortDemo.selectSort2(arr1);   //选择排序
//            ShellSortDemo.shellSort2(arr1);     //希尔排序
            HeapSortDemo.heapSort(arr1);          //堆排序
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                flag = false;
                printArray(arr1);   //若两者不同 打印出来 找bug
                printArray(arr2);
                printArray(arr3);
                break;

            }
        }
            System.out.println(flag? "Nice!" :"Fuck!");
            int[] arr=generatorRandomArray(maxSize,maxValue);
            printArray(arr);
//        BubbleSortDemo.bubbleSort(arr);    //冒泡排序
//        InsertSortDemo.insertSort(arr);    //插入排序
//        MergeSortDemo.mergeSort(arr);      //归并排序
//        QuickSortDemo.quickSort2(arr);     //快速排序
//        SelectSortDemo.selectSort2(arr);   //选择排序
//        ShellSortDemo.shellSort2(arr);     //希尔排序
        HeapSortDemo.heapSort(arr);          //堆排序
            printArray(arr);
        }



    //绝对正确的数组排序
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 数组随机生成器
     *
     * @param MaxSize  数组随机产生的最大长度 [1,Maxsize] int
     * @param MaxValue 数组中的随机产生的最大值 [1 MaxValue] int
     * @return
     */
    public static int[] generatorRandomArray(int MaxSize, int MaxValue) {
        int[] arr = new int[(int) ((MaxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((MaxValue + 1) * Math.random());
        }
        return arr;
    }

    /**
     * 拷贝数组
     *
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //打印数组
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
