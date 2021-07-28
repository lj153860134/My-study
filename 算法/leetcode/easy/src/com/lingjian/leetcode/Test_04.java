package com.lingjian.leetcode;

/**
 * @description: 两个有序数组的中位数
 *               给定两个大小为 m 和 n 的正序
 *              （从小到大）数组nums1 和nums2。
 *               请你找出这两个正序数组的中位数
 *               并且要求算法的时间复杂度为O(log(m + n))。
 *               你可以假设nums1和nums2不会同时为空。
 *
 * @author: Ling Jian
 * @date: 2020-04-15 20:27
 **/
public class Test_04 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        int res=findKth(nums1, nums2, 0, 0, left)+findKth(nums1, nums2, 0, 0, right);
        return res/2.0;

    }

    public static int findKth(int[] nums1,int[] nums2,int i,int j,int k){
        if(i>=nums1.length) return nums2[j + k - 1];
        if(j>=nums2.length) return nums1[i + k - 1];
        if(k==1){
            return Math.min(nums1[i], nums2[j]);
        }
        int mid1 = (i + k / 2-1) < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = (j + k / 2-1) < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if(mid1<mid2){
            return findKth(nums1, nums2, i + k / 2, j, k - k / 2);
        }else{
            return findKth(nums1, nums2, i , j+ k / 2, k - k / 2);
        }
    }


    //练习用
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        int res = findKth1(nums1, nums2, 0, 0, left) + findKth1(nums1, nums2, 0, 0, right);
        return res / 2.0;
    }

    public static int findKth1(int[] nums1,int[] nums2,int i,int j,int k){
        if(i>=nums1.length) return nums2[j + k - 1];
        if(j>= nums2.length) return nums1[i + k - 1];
        if(k==1) return Math.min(nums1[i], nums2[j]);
        int mid1 = (i + k / 2 - 1) < nums1.length ? nums1[i - k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = (j + k / 2 - 1) < nums2.length ? nums1[j - k / 2 - 1] : Integer.MAX_VALUE;
        if(mid1<=mid2){
            return findKth1(nums1, nums2, i + k / 2, j, k - k / 2);
        }else{
            return findKth1(nums1, nums2, i, j + k / 2, k - k / 2);
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int left=(m+n+1)/2;
        int right=(m+n+2)/2;
        int res=findKth2(nums1,nums2,left,0,0)+findKth2(nums1,nums2,left,0,0);
        return res/2.0;
    }
    public int findKth2(int[] nums1,int[] nums2,int k,int i,int j){
        if(i>=nums1.length) return nums2[j+k-1];
        if(j>=nums2.length) return nums1[i+k-1];
        if(k==1) return Math.min(nums1[i],nums2[j]);
        int mid1=(i+k/2-1)<nums1.length?nums1[i+k/2-1]:Integer.MAX_VALUE;
        int mid2=(j+k/2-1)<nums2.length?nums2[j+k/2-1]:Integer.MAX_VALUE;
        if(mid1<mid2){
            return findKth(nums1,nums2,k-k/2,i+k/2,j);
        }else{
            return findKth(nums1,nums2,k-k/2,i,j+k/2);
        }

    }



}

