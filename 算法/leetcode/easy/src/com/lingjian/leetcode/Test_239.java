package com.lingjian.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @description: 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字
 *               滑动窗口每次只向右移动一位。  返回滑动窗口中的最大值
 * @author: Ling Jian
 * @date: 2020-06-12 14:53
 **/
public class Test_239 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));

    }

    public static  int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int L=0;
        int R=0;
        int index=0;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        while(R<nums.length){
            while(!list.isEmpty()&&nums[list.peekLast()]<=nums[R]){
                list.pollLast();
            }
            list.offerLast(R++);
            if(R==k){
                res[index++]=nums[list.peekFirst()];
            }
            if(R>k){
                if(list.peekFirst()==L){
                    list.pollFirst();
                }
                L++;
                res[index++]=nums[list.peekFirst()];
            }
        }


        return res;
    }
}
