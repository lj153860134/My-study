package com.lingjian_1;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @description: 堆排序
 * @author: Ling Jian
 * @date: 2019-12-13 15:07
 **/
public class HeapSortDemo {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,6,0,4};

        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //使数组成为大根堆数组
    public  static void heapSort(int[] arr) {
        if(arr==null||arr.length<2){
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
           heapInsert(arr,i);
        }
        for (int i = arr.length; i >=1 ; i--) {
            swap(arr,0,i-1);
            heapIfy(arr,0,i-1);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while(arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }
    }

    public static void heapIfy(int[] arr,int index,int heapSize){

        int left=index*2+1;
        while(left<heapSize){
            int largest=left+1<heapSize&&arr[left]<arr[left+1]
                    ?left+1:left;
            largest=arr[largest]>arr[index]?largest:index;
            if(largest==index){
                break;
            }
            swap(arr,largest,index);
            index=largest;
            left=largest*2+1;
        }
    }

    public static void swap(int[] arr, int j, int i) {
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }
}
