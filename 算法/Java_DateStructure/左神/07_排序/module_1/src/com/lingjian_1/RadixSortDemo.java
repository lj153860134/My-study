package com.lingjian_1;

import java.util.Arrays;

/**
 * @description: 基数排序
 * @author: Ling Jian
 * @date: 2019-12-09 15:14
 **/
public class RadixSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,11};
        System.out.print("基数排序前:");
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println("--------");
        System.out.print("基数排序后:");
        System.out.println(Arrays.toString(arr));


    }

    public static void radixSort(int[] arr) {
        if(arr==null||arr.length<2){
            return;
        }
        //定义一个二维数组
        //每一行作为一个桶 bucket[i]放数字为i的数据
        //桶的长度最大为arr.length
        int[][] bucket = new int[10][arr.length];
        //定义一个一维数组
        //bucketIndex[i]为第i个桶的索引
        int[] bucketIndex = new int[10];
        int digitNumber = 0; //用于判断的取余后数字（个位 十位 百位）
        //取出该数组中的最高位数
        int maxDigit = digit(arr);
       for(int k=0,n=1;k<maxDigit;k++,n*=10) {
            int index = 0; //从桶中取出数据到原数组的索引
            for (int i = 0; i < arr.length; i++) {
                digitNumber = arr[i] /n% 10;
                bucket[digitNumber][bucketIndex[digitNumber]] = arr[i];
                bucketIndex[digitNumber]++;
            }
            for (int i = 0; i < 10; i++) {
                if (bucketIndex[i] != 0) {
                    for (int j = 0; j < bucketIndex[i]; j++) {
                        arr[index] = bucket[i][j];
                        index++;
                    }
                }
                //第i+1轮处理后
//                需要将每个bucketIndex[i]置0    !!!!!!!!!
                //这里一定要记住 不然index会越界
                bucketIndex[i]=0;
            }
            System.out.println("--------");
            System.out.println(Arrays.toString(arr));
        }

    }

    /**
     * @description: 取出该数组中的最高位数
     * @param:
     * @return:
     * @author: Ling Jian
     * @date: 2019/12/9 4:24 下午
     */
    public static int digit(int[] arr) {
        int max = 0; //先求出最大值 再求最高的位数
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        String str = String.valueOf(max);
        return str.toCharArray().length;
    }
}
