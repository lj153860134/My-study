package com.lingjian_1;

import java.util.Arrays;

/**
 * @description: 插入排序
 * @author: Ling Jian
 * @date: 2019-12-07 20:38
 **/
public class InsertSortDemo {
    public static void main(String[] args) {
        int[] arr= new int[]{5,4,3,2,1};
        System.out.print("插入排序前:");
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println("--------");
        System.out.print("插入排序后:");
        System.out.println(Arrays.toString(arr));

        //给80000个数据 测试插入排序的速度
//        int[] arr = new int[80000];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 80000 + 1); //随机生成[1,80000]的整数
//        }
//
//        Date start = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("排序前时间:" + sdf.format(start));
//        insertSort2(arr);
//        Date end = new Date();
//        System.out.println("排序后时间:" + sdf.format(end));

    }

    /**
     * @description: 左神插入排序算法（牛逼）
     * @param: [arr]
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/7 9:26 下午
     */
    public static void insertSort(int[] arr) {
        if(arr==null||arr.length<2) {
            return;
        }
        for (int i = 1; i <arr.length ; i++) {
            for (int j = i-1;j>=0&&arr[j]>arr[j+1]  ; j--) {
                swap(arr,j,j+1);
            }
//            System.out.println("--------");
//            System.out.print("第" + (i + 1) + "次插入后");
//            System.out.println(Arrays.toString(arr));

        }

    }



    /**
     * @description: 韩老师插入排序（其实两者差不多）(更好理解）
     * @param: [arr]
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/7 9:34 下午
     */
    public static void insertSort2(int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];   //定义待插入的数
            int insertIndex = i - 1;        //该数应该插入位置的索引
            //insertIndex>=0保证在给insertVal找插入位置 不越界
            //insertVal<arr[insertIndex]待插入的数 还没有找到插入的位置
            //需要将arr[insertIndex]后移  即arr[insertIndex+1]=arr[insertIndex];
            if (arr[insertIndex] > insertVal) {
                count++;
                while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                    arr[insertIndex + 1] = arr[insertIndex];
                    insertIndex--;
                }
            }
            //当退出while循环时  说明插入的位置找到 insertIndex+1
            if (insertIndex != i + 1) {
                arr[insertIndex + 1] = insertVal;
            }
            System.out.println("--------");
            System.out.println(count);
            System.out.print("第" + i + "次插入后");
            System.out.println(Arrays.toString(arr));

        }
    }

    /**
     * @description: 交换arr[i]与arr[j]
     * @param: [arr, i, j]
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/10 3:08 下午
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
