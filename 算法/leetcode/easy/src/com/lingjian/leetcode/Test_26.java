package com.lingjian.leetcode;

import java.util.Arrays;

/**
 * @description: 给定一个排序数组
 *               你需要在原地删除重复出现的元素
 *               使得每个元素只出现一次
 *               返回移除后数组的新长度
 *               不要使用额外的数组空间
 *               你必须在原地修改输入数组
 *               并在使用O(1)额外空间的条件下完成
 * @author: Ling Jian
 * @date: 2020-08-10 09:51
 **/
public class Test_26 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int res = removeDuplicates(nums);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
//        if(nums==null||nums.length==0){
//            return 0;
//        }
//        if(nums.length==1){
//            return 1;
//        }

        int p=0;
        int q=1;
        while(q<nums.length){
            if(nums[p]!=nums[q]){
                int temp=nums[q];
                nums[q]=nums[p+1];
                nums[p+1]=temp;
                p++;
            }
            q++;
        }
        return p+1;
    }

}

