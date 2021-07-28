package com.lingjian.leetcode;

/**
 * @description: 长度为k且平均值大于等于阈值的子数组数目
 * @author: Ling Jian
 * @date: 2020-05-27 17:04
 **/
public class Test_1343 {
    public static void main(String[] args) {
        int [] arr=new int[]{2,2,2,2,5,5,5,8};
        int k=3;
        int threshold=4;
        int res = numOfSubarrays(arr, k, threshold);
        int res1 = numOfSubarrays1(arr, k, threshold);
        System.out.println(res);
        System.out.println(res1);
    }

    private static int numOfSubarrays(int[] arr, int k, int threshold) {
        int aim = k * threshold;
        int sum = 0;
        int count=0;
        int L=0;
        int R=k-1;
        for (int i = 0; i <k ; i++) {
            sum += arr[i];
        }
        while(R<arr.length){
            if (sum >= aim) {
//                System.out.println(L+"===="+R);
                count++;
            }
            if (R == arr.length - 1) {
                break;
            }
            sum = sum - arr[L++] + arr[++R];

        }
        return count;

    }

    //练习版
    private static int numOfSubarrays1(int[] arr, int k, int threshold) {
        int aim = k * threshold;
        int L=0;
        int R=k;
        int sum=0;
        int count=0;
        for (int i = 0; i <k ; i++) {
            sum += arr[i];
        }
        while(R<arr.length){
           if(sum>=aim){
               count++;
           }
           sum=sum-arr[L++]+arr[R++];

        }

        //这里得加一次判断 才行 不然不会遗漏最后一次
        if(sum>=aim){
            count++;
        }
        return count;
    }


}
