package com.lingjian.jianzhi;

import java.util.Arrays;

/**
 * @description: 给定一个数组 A[0,1,…,n-1]
 *               请构建一个数组 B[0,1,…,n-1]
 *               其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]
 *               不能使用除法
 * @author: Ling Jian
 * @date: 2020-06-30 18:42
 **/
public class Test_66 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] res = constructArr(a);
        System.out.println(Arrays.toString(res));
        
    }

    public static int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        int temp=1;
        for (int i = 0; i <res.length ; i++) {
            res[i]=temp;
            temp *= a[i];
        }
        temp=1;
        for (int i = res.length-1; i >=0; i--) {
            res[i]*=temp;
            temp *= a[i];
        }
        return res;
    }
}
