package com.lingjian.jianzhi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 输入整数数组 arr
 *               找出其中最小的 k 个数
 * @author: Ling Jian
 * @date: 2020-07-01 18:11
 **/
public class Test_40 {
    public static void main(String[] args) {
        int[] arr=new int[]{0,1,2,1};
        int k=1;
        int[] res = getLeastNumbers1(arr, k);
        System.out.println(Arrays.toString(res));
    }

    //数组排序
    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }

    //大根堆
    public static int[] getLeastNumbers1(int[] arr, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : arr) {
            queue.add(i);
        }
        while(queue.size()>k){
            queue.poll();
        }
        int[] res = new int[k];
        int index=0;
        for (Integer integer : queue) {
            res[index++] = integer;
        }
        return res;

    }
}
