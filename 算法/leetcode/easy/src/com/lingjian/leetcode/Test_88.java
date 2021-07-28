package com.lingjian.leetcode;

import java.util.Arrays;

/**
 * @description: 给你两个有序整数数组nums1和nums2
 * 请你将 nums2 合并到 nums1 中
 * 使 nums1 成为一个有序数组。
 * @author: Ling Jian
 * @date: 2020-08-24 23:57
 **/
public class Test_88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,0,0,0,0,0};
        int[] nums2 = new int[]{1,2,3,5,6};
        int m =1;
        int n = 5;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

    }
    //插入排序
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m];
        System.arraycopy(nums1, 0, nums, 0, m);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums1));
        if(m==0){
            for (int i = 0; i <n ; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        for (int i = m; i <nums1.length ; i++) {
            nums1[i] = nums2[i - m];
//            System.out.println(Arrays.toString(nums1));

            int insertValue=nums1[i];
            int insertIndex=i-1;
            if(nums1[insertIndex]>insertValue){
                while(insertIndex>=0&&nums1[insertIndex]>insertValue){
                    nums1[insertIndex + 1] = nums1[insertIndex];
                    insertIndex--;
                }

            }
            if(insertIndex!=i-1){
                nums1[insertIndex + 1] = insertValue;
            }
        }

    }


    //从后面开始遍历
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        m--;
        n--;
        while(n>=0){
            while(m>=0&&nums1[m]>nums2[n]){
                swap(nums1,i--,nums1,m--);
            }
           swap(nums1,i--,nums2,n--);
        }



    }
    public static void swap(int[] A,int a,int[] B,int b){
        int temp = A[a];
        A[a] = B[b];
        B[b] = temp;
    }

}
