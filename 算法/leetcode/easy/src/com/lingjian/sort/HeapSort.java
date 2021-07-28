package com.lingjian.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @description: 堆排序
 * @author: Ling Jian
 * @date: 2020-05-09 15:44
 **/
public class HeapSort {
    public static void main(String[] args) {
        int[] arr1 = new int[]{6,5};
        int[] arr2 = new int[]{6,5};
//        sort(arr1);
        priorityQueueSort(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }


    //法一：使用数组来建立大根堆
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        for (int i = arr.length-1; i >= 1; i--) {
            swap(arr, 0, i );
            heapIfy(arr, 0, i );
        }

    }

    //法二：直接用系统自带的优先级队列（堆）来排序
    public static void priorityQueueSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        //lambda表达式
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });

        for (int i = 0; i < arr.length; i++) {
            maxHeap.offer(arr[i]);
        }
        for (int i = arr.length-1; i>=0  ; i--) {
            arr[i] = maxHeap.poll();
        }
    }

    //使数组成为一个大根堆
    private static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    //使根（最大值）与最后一个交换 继续成为一个大根堆
    private static void heapIfy(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                return;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
