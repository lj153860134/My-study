package com.lingjian;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-03-19 19:28
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int res=function(n);
        System.out.println(res);
    }

    public static int function(int n){
        if(n>=1&&n<=2){
           return 0;
        }
        Scanner sc=new Scanner(System.in);
        int max=Integer.MIN_VALUE;
        int[] arr1=new int[n];
        int[] arr2=new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i]=sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arr2[i]=sc.nextInt();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        max=Math.max(arr1[n-1]+arr1[n-2]+arr1[n-3],arr2[n-1]+arr2[n-2]+arr2[n-3]);
        return max;
    }
}
