package com.lingjian.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给定一个整数数组nums
 *               按要求返回一个新数组counts
 *               数组 counts 有该性质
 *               counts[i]的值是nums[i]右侧小于nums[i]的元素的数量
 * @author: Ling Jian
 * @date: 2020-07-11 16:46
 **/
public class Test_315 {
    public static void main(String[] args) {
        int[] nums=new int[] {0,2,1};
        List<Integer> list = countSmaller(nums);
        System.out.println(Arrays.toString(list.toArray()));

    }


    public static List<Integer> countSmaller(int[] nums) {
        int[] res=new int[nums.length];
        if(nums==null||nums.length<=1){
            return new ArrayList<>();
        }
        process(nums, 0, nums.length - 1,res);
        List<Integer> list = new ArrayList<>();
        for (int re : res) {
            list.add(re);
        }
        return list;
    }

    public static void process(int[] nums,int left,int right,int[] res){
        if(left>=right){
            return;
        }
        int mid=left+((right-left)>>1);
        process(nums,left,mid,  res);
        process(nums,mid+1,right,res);
        merge(nums, left, right, mid,res);
    }

    public static void merge(int[] nums, int left, int right,int mid,int[] res){
        int[] help=new int[right-left+1];
        int p1=left;
        int p2=mid+1;
        int index=0;
        while(p1<=mid&&p2<=right){
            if(nums[p1]>nums[p2]){
                res[p1]+=right-p2+1;
                help[index++]=nums[p1++];
            }else{
                help[index++]=nums[p2++];
            }
        }
        while(p1<=mid){
            help[index++]=nums[p1++];
        }

        while(p2<=right){
            help[index++]=nums[p2++];
        }
        for (int i = 0; i <help.length ; i++) {
            nums[i + left] = help[i];
        }
    }
}
