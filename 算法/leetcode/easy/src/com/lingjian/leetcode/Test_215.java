package com.lingjian.leetcode;

import com.sun.corba.se.impl.naming.cosnaming.InternalBindingKey;

/**
 * @description: 在未排序的数组中找到第k个最大的元素
 *               请注意，你需要找的是数组排序后的第k个最大的元素
 *               而不是第 k 个不同的元素
 * @author: Ling Jian
 * @date: 2020-07-20 16:32
 **/
public class Test_215 {
    public static void main(String[] args) {
        int[] nums = new int[]{7,6,5,4,3,2,1};
        int k=2;
        int res = findKthLargest(nums, k);
        System.out.println(res);


    }

    public static int findKthLargest(int[] nums, int k) {
        return process(nums, 0, nums.length - 1, nums.length-k);
    }

    public static int process(int[] nums, int left, int right, int k) {
        if(left>=right){
            return nums[left];
        }
        int less=left-1;
        int more=right+1;
        int cur=left;
        int num =left+((right-left)>>1);
        num = nums[num];
        while(cur<more){
            if(nums[cur]>num){
                swap(nums, --more, cur);
            }else if(nums[cur]<num){
                swap(nums,++less,cur++);
            }else{
                cur++;
            }
        }
        if(k<less){
            return process(nums, left, less, k);
        }else if(k>more){
            return process(nums, more, right, k);
        }else{
            return nums[k];
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
