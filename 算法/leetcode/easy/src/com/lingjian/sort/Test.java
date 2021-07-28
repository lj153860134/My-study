package com.lingjian.sort;

import java.util.Arrays;

/**
 * @description: 排序数组对数器
 * @author: Ling Jian
 * @date: 2020-05-08 15:59
 **/
public class Test {
    public static void main(String[] args) {
        int testTime=10000;
        int maxSize=100;
        int maxValue=100;
        boolean flag = true;
//        int[] arr = new int[]{5,4,3,2,1};
        for (int i = 0; i <testTime ; i++) {
            int[] arr1 = generatorRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            //我的排序方法
//            BubbleSort.sort(arr1);
//            SelectSort.sort(arr1);
//            ShellSort.sort(arr1);
//            QuickSort.sort(arr1);
//            MergeSort.sort(arr1);
            HeapSort.sort(arr1);
//            HeapSort.priorityQueueSort(arr1);
            //绝对正确的排序方法

            sort(arr2);
            if (!isEqual(arr1, arr2)) {
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                flag = false;
                break;
            }

        }
        System.out.println(flag?"Nice":"Fuck!!!!!!");
//        BubbleSort.sort(arr);
//        printArray(arr);

    }


    //绝对正确的数组排序
    public static void sort(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 数组随机生成器
     *
     * @param maxSize  数组随机产生的最大长度 [1,Maxsize] int
     * @param maxValue 数组中的随机产生的最大值 [1 MaxValue] int
     * @return
     */
    public static int[] generatorRandomArray(int maxSize, int maxValue) {
        int[] arr=new int[(int)((maxSize+1)*Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)((maxValue+1)*Math.random());
        }
        return arr;
    }


    /**
     * 拷贝数组
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        return Arrays.copyOf(arr, arr.length);
    }


    /**
     * 判断两个数组是否相等
     * @param arr1
     * @param arr2
     * @return
     */
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
        for (int i = 0; i <arr1.length ; i++) {
            if(arr1[i]!=arr2[i]){
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
