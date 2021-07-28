package com.lingjian.leetcode;

import java.util.Random;

/**
 * @description: 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。
 *                  可以假设给定的数字一定存在于数组中
 *                  注意：数组大小可能非常大
 *                  使用太多额外空间的解决方案将不会通过测试
 * @author: Ling Jian
 * @date: 2020-06-18 15:29
 **/
public class Test_398 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        Solution s = new Solution(nums);
        for (int i = 0; i <10 ; i++) {
            System.out.println(s.pick(1));

        }

    }

    static class Solution {
        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }


        public int pick(int target) {
            int res=-1;
            Random random = new Random();
            int count=0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]==target){
                    count++;
                    if(random.nextInt(count)==0){
                        res=i;
                    }
                }
            }
            return res;
        }
    }
}
