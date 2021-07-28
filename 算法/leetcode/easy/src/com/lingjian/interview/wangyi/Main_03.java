package com.lingjian.interview.wangyi;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-05 23:17
 **/
public class Main_03 {
    public static void main(String[] args) {
        int[] nums = new int[]{16,10,0,3,22,1,14,7,1,12,15};
        int res = findLengthOfShortestSubarray(nums);
        System.out.println(res);
    }
    public static int findLengthOfShortestSubarray(int[] arr) {
        if(arr.length==1){
            return 0;
        }
        int L=0;
        int R = arr.length - 1;
        while(L<arr.length-1){
            if(arr[L]<=arr[L+1]){
                L++;
            }else{
                break;
            }
        }
        if(L==arr.length-1){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        while(L>=0){
            while(arr[R]>=arr[L]){
                R--;
                if(arr[R]>arr[R+1]){
                    break;
                }
            }
            res = Math.min(res, R - L);
            L--;
            R = arr.length - 1;
        }
        while(arr[R]>=arr[R-1]){
            R--;
            res = Math.min(res, R);
        }
        return res;
    }
}
