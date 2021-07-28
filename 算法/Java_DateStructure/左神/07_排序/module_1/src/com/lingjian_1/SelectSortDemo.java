package com.lingjian_1;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @description: 选择排序
 * @author: Ling Jian
 * @date: 2019-12-07 16:01
 **/
public class SelectSortDemo {
    public static void main(String[] args) {
        int arr[]=new int[]{1,4,5,2,3};
        System.out.print("选择排序前:");
        System.out.println(Arrays.toString(arr));
        selectSort2(arr);
        System.out.println("--------");
        System.out.print("选择排序后:");
        System.out.println(Arrays.toString(arr));

        //给80000个数据 测试选择排序的速度
//        int[] arr = new int[80000];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 80000 + 1); //随机生成[1,80000]的整数
//        }
//
//        Date start = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("排序前时间:" + sdf.format(start));
//        selectSort2(arr);
//        Date end = new Date();
//        System.out.println("排序后时间:" + sdf.format(end));
    }

    /**
     * @description: 选择排序算法
     * @param: [arr]
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/7 4:54 下午
     */
    public static void selectSort(int[] arr) {
        int temp = 0; //辅助变量 用于交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("--------");
            System.out.print("第"+(i+1)+"次选择排序后: ");
            System.out.println(Arrays.toString(arr));
        }


    }


    //优化选择排序。
    public static void selectSort2(int[] arr) {
        int min = 0;
        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
//            System.out.println("--------");
//            System.out.print("第"+(i+1)+"次选择排序后: ");
//            System.out.println(Arrays.toString(arr));
        }
    }
}
