package com.lingjian.interview.alibaba;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;


public class Test_2 {

        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            int n = sc.nextInt();
//            int[] arr = new int[n];
//            for (int i = 0; i < arr.length; i++) {
//                arr[i] = sc.nextInt();
//            }
            int[] arr = new int[]{1,4,6};
//            int  res = solution(arr);
//            System.out.println(res);
//            Arrays.sort(arr);
//            int res=process(arr,0,arr.length-1);
//            System.out.println(res);
        }

            public static int solution(int[] arr){
            Arrays.sort(arr);
            int i =0,j = arr.length-1;
            int res = 0;
            while (i < j) {
                res+=arr[j--]-arr[i++];
            }
            System.out.println(res);
                return res;
        }
        static int num=0;
        public static int process(int[] arr, int left,int right){
            if(left==arr.length||right<0||left>=right){
                return 0;
            }
            num += process(arr, left + 1, right -1) + arr[right] - arr[left];
            return num;
        }



}
