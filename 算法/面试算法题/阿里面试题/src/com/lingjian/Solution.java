package com.lingjian;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-03-20 09:10
 **/
public class Solution {
    public static void main(String[] args) {
        int[] arr=new int[]{1,1,1,2,2,2,2,2,1,1};
        int res=function(arr);
    }

    public static int function(int[] arr){
        int sum=0;
        for (int i = 0;i <10 ; i++) {
            sum+=arr[i];
        }
        if(sum==0){
            return 0;
        }
        int count=0;
        for (int i = 2; i <10 ; i++) {
            if(arr[i-2]>=2&&arr[i-1]>=2&arr[i]>=2){
                arr[i-2]-=2;
                arr[i-1]-=2;
                arr[i]-=2;
                count=function(arr)+1;
            }
        }

        return 0;

    }
}
