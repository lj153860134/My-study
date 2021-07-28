package com.lingjian.interview.bilibili;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-04 20:00
 **/
public class Main {
    public static void main(String[] args) {
        int[] arr=new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        int res=GetMaxConsecutiveOnes(arr,k);
        System.out.println(res);
    }
    public static int GetMaxConsecutiveOnes (int[] arr, int k) {
        int L=0;
        int R=0;
        int res=0;
        int temp = arr[0] == 0 ? 1 : 0;
        int n=arr.length;
        while(L<R&&R<n){
            if(temp<=k){
                res = Math.max(R - L + 1, res);
               R++;
               if(arr[R]==0){
                   temp++;
               }
            }else{
                if(arr[L]==0){
                    temp--;
                }
                L--;
            }
        }
        return res;
    }
}
