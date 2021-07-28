package com.lingjian;

import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-03-19 19:43
 **/
public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        int res=function(arr);
        System.out.println(res);
    }

    public static int function(int[] arr) {
        int[] help = new int[arr.length ];
        for (int i = 0; i < arr.length; i++) {
            int num = 1;
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[j] > arr[j-1]) {
                    num++;
                } else {
                    break;
                }
            }
            help[i] = num;
        }
        help[arr.length-1]=1;
        int max = help[0];
        for (int i = 1; i < help.length - 1; i++) {
            if (help[i] == 1) {
                max = Math.max(max, help[i - 1] + help[i + 1]-1);
            }
        }
        if(max==help[0]){
            max--;
        }
        return max;
    }
}
