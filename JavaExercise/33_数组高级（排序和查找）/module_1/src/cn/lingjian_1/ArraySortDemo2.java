package cn.lingjian_1;

import static cn.lingjian_1.ArraySortDemo1.*;

/**
 * @author lingjian
 * @date 2019-09-02 - 14:33
 */
/*
 * 选择排序基本思路：
 * 把第一个元素依次和后面的所有元素进行比较。
 * 第一次结束后，就会有最小值出现在最前面。
 * 依次类推
 */
public class ArraySortDemo2 {
    public static void main(String[] args) {
        int[] arr={24,69,80,57,13,14};
        printArray(arr);
        sectionSort(arr);
        printArray(arr);
    }


    public static void sectionSort(int[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = i; j <arr.length-1 ; j++) {
                if(arr[i]>arr[j+1]){
                    int temp =arr[i];
                    arr[i]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
