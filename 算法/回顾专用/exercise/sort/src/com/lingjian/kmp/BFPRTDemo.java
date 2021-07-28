package com.lingjian.kmp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 一个无序数组中找打第k小或者第k大的数
 * @author: Ling Jian
 * @date: 2020-05-20 15:23
 **/
public class BFPRTDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1,2,5,2, 3, 4, 5, 6, 7, 8, 9};
        int k=7;
        //方法一： 利用大根堆
        int[] res1 = getMinKNumsByHeap(arr, k);
        //方法二：利用优先级队列
        int[] res2 = getMinKNumsByPQ(arr, k);
        //方法三：利用BFPRT算法 (见左神算法代码初级班2)
//        int[] res3 = geMinKNumsByBFPRT(arr, k);
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
    }


    private static int[] getMinKNumsByHeap(int[] arr, int k) {
        if (k > arr.length || k < 1 || arr == null) {
            return arr;
        }

        int[] kHeap = new int[k];

        for (int i = 0; i <k ; i++) {
            heapInsert(kHeap,arr[i],i);
        }

        for (int i = k; i <arr.length ; i++) {
            if (arr[i] < kHeap[0]) {
                kHeap[0] = arr[i];
                heapIfy(kHeap, 0, k);
            }
        }
        return kHeap;
    }



    private static void heapInsert(int[] kHeap,int value,int i) {
        kHeap[i] = value;
        while(kHeap[i]>kHeap[(i-1)/2]){
            swap(kHeap,i,(i-1)/2);
            i=(i-1)/2;
        }
    }

    private static void heapIfy(int[] kHeap, int index, int heapSize) {
        int left=2*index+1;
        while(left<heapSize) {
            int right=left+1;
            int largest = right < heapSize && kHeap[left] > kHeap[right] ? left : right;
            largest = kHeap[largest] > kHeap[index] ? largest : index;
            if (largest == index)
                break;

                index=largest;
                left=2*index+1;

        }


    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }


    private static int[] getMinKNumsByPQ(int[] arr, int k) {
        if (k > arr.length || k < 1 || arr == null) {
            return arr;
        }

        int[] res = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i <k ; i++) {
            queue.offer(arr[i]);
        }

        for (int i = k; i <arr.length ; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        int index=0;
        while(!queue.isEmpty()){
            res[index++] = queue.poll();
        }

        return res;
    }



}
