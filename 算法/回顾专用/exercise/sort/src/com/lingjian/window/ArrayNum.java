package com.lingjian.window;

import java.util.LinkedList;

/**
 * @description:  最大值减最小值<=num(固定值)的子数组数量
 * @author: Ling Jian
 * @date: 2020-05-20 17:36
 **/
public class ArrayNum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3,4,5,6,7,8,9};
        int num =2 ;
        int res = getNum(arr, num);
        System.out.println(res);
    }

    private static int getNum(int[] arr, int num) {
        if (arr== null || arr.length==0) {
            return 0;
        }

        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();
        int L=0;
        int R=0;
        int res=0;
        while(L<arr.length){
            while (R < arr.length) {
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                    qmax.pollLast();
                }
                qmax.offerLast(R);

                while (!qmin.isEmpty() && arr[qmin.peekLast()] >=arr[R]) {
                    qmin.pollLast();
                }
                qmin.offerLast(R);
                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
                    break;
                }
                R++;
            }
            if (qmax.peekFirst() == L) {
                qmax.pollFirst();
            }
            if (qmin.peekFirst() == L) {
                qmin.pollFirst();
            }
            res+=R-L;
            L++;
        }





        return res;
    }
}
