package com.lingjian_1;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ForkJoinPool;

/**
 * @description: 冒泡排序
 * @author: Ling Jian
 * @date: 2019-12-07 14:54
 **/
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,5,3};
        System.out.print("冒泡排序前:");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.print("冒泡排序后:");
        System.out.println(Arrays.toString(arr));

        //给80000个数据 测试冒泡排序的速度
//        int[] arr=new int[80000];
//        for (int i = 0; i <arr.length ; i++) {
//            arr[i]=(int)(Math.random()*80000+1); //随机生成[1,80000]的整数
//        }
//
//        Date start=new Date();
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("排序前时间:"+sdf.format(start));
//        bubbleSort(arr);
//        Date end=new Date();
//        System.out.println("排序后时间:"+sdf.format(end));

    }

    /**
     * @description: 冒泡排序算法
     * @param: [arr]
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/7 3:01 下午
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0;  //辅助变量用于交换
        int count=0; //判断每次冒泡交换的次数 用于优化冒泡算法
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    count++;
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }

//            System.out.println("----------");
//            System.out.print("第" + (i + 1) + "次冒泡后:");
//            System.out.println(Arrays.toString(arr));
            if(count==0)
                break;
            else
                count=0; //重置count 用于下一次判断
        }
//        System.out.println("----------");

    }

    /**
     * @description: 打印数组
     * @param: [arr]
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/7 3:00 下午
     */
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print("[ " + arr[i]);
            } else {
                System.out.print(", " + arr[i]);
            }
        }
        System.out.println(" ]");
    }
}
