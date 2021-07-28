package com.lingjian.dandiao_stack_queue.lingjian_2;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @description: 利用单调双向队列 求数组中一个窗口的最大值
 * @author: Ling Jian
 * @date: 2020-03-13 14:46
 **/
public class GetWindowMax {
    public static void main(String[] args) {
        int[] arr=new int[]{4,3,5,4,3,3,6,7};
        int windowLength=3;
        int[] res = getMax(arr, windowLength);
        System.out.println(Arrays.toString(res));
    }

    public static int[] getMax(int[] arr, int w) {
        if(arr==null||w<1||arr.length<w){
            return null;
        }
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        for (int i = 0; i <arr.length ; i++) {
            while(!list.isEmpty()&&arr[list.peekLast()]<arr[i]){
                list.pollLast();
            }
            list.addLast(i);
            if(list.peekFirst()==i-w){
                list.pollFirst();
            }
            if(i>=w-1){
                res[i+1-w]=arr[list.peekFirst()];
            }

        }

        return res;
    }


}
