package com.lingjian_1;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @description: 希尔排序
 * @author: Ling Jian
 * @date: 2019-12-07 22:09
 **/
public class ShellSortDemo {
    public static void main(String[] args) {
//        int[] arr = new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        System.out.print("希尔排序前:");
//        System.out.println(Arrays.toString(arr));
//        shellSort2(arr);
//        System.out.println("--------");
//        System.out.print("希尔排序后:");
//        System.out.println(Arrays.toString(arr));

        //给80000个数据 测试冒泡排序的速度
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000 + 1); //随机生成[1,80000]的整数
        }

        Date start = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序前时间:" + sdf.format(start));
        shellSort2(arr);
        Date end = new Date();
        System.out.println("排序后时间:" + sdf.format(end));
    }

    /**
     * @description: 希尔排序（交换法） 耗时较长
     * 实质是 先分组 在进行冒泡排序
     * @param: [arr]
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/7 11:04 下午
     */
    public static void shellSort1(int[] arr) {
        int temp = 0;   //辅助变量 用于交换
        int count = 0;  //判断次数
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j + gap];
                        arr[j + gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            System.out.println("--------");
            System.out.print("第" + (++count) + "排序后: ");
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * @description: 希尔算法（移位法） 时间很短（推荐）
     * @param: [arr]
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/7 11:16 下午
     */
    public static void shellSort2(int[] arr) {
        int count = 0;    //计算分组的次数
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            count++;
            for (int i = gap; i < arr.length; i++) {
                int insertVal = arr[i];
                int insertIndex = i - gap;
                if (arr[insertIndex] > insertVal) {
                    while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                        arr[insertIndex + gap] = arr[insertIndex];
                        insertIndex -= gap;
                    }
                }
                if (insertIndex != i - gap)
                    arr[insertIndex + gap] = insertVal;
            }
//            System.out.println("--------");
//            System.out.print("第" + count + "次分组排序后: ");
//            System.out.println(Arrays.toString(arr));

        }
    }
}
