package cn.lingjian_1;

import cn.itcast.SortTest;

import static cn.lingjian_1.ArraySortDemo1.*;

/**
 * @author lingjian
 * @date 2019-09-02 - 15:11
 */
/*
*插入排序的基本方法是：
*  每一步将一个待排序的元素，按其排序码的大小，
*  插入到前面已经排好序的一组元素的适当位置上去，直到元素全部插入为止。
*  可以选择不同的方法在已经排好序数据表中寻找插入位置。
*  根据查找方法不同，有多种插入排序方法，下面要介绍的是直接插入排序。
*
*
* */
public class ArraySortDemo3 {
    public static void main(String[] args) {
        int[] arr={24,69,80,57,13,14};
        printArray(arr);
        insertSort(arr);
        printArray(arr);
    }

    public static void insertSort(int[] arr){
            for (int i = 1; i < arr.length; i++) {
                for (int j = i; (j > 0) && (arr[j] < arr[j - 1]); j--) {
                    SortTest.swap(arr, j, j - 1);
                }
            }

        }
    }
