package com.lingjian_3;

import java.util.Arrays;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2019-12-14 11:28
 **/
public class maxGapDemo {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(maxGap(arr));
    }

        public static int maxGap(int[] nums) {
            if (nums == null || nums.length < 2) {
                return 0;
            }
            int len = nums.length;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }
            if (min == max) {
                return 0;
            }
            boolean[] hasNum = new boolean[len + 1];
            int[] maxs = new int[len + 1];
            int[] mins = new int[len + 1];
            int bid = 0;
            for (int i = 0; i < len; i++) {
                bid = bucket(nums[i], len, min, max);
                mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
                maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
                hasNum[bid] = true;
            }
            System.out.println(Arrays.toString(mins));
            System.out.println(Arrays.toString(maxs));
            System.out.println(Arrays.toString(hasNum));

            int res = 0;
            int lastMax = maxs[0];
            for (int i = 1;i <= len; i++) {
                if (hasNum[i]) {
                    res = Math.max(res, mins[i] - lastMax);
                    lastMax = maxs[i];
                }
            }
            return res;
        }

        public static int bucket(long num, long len, long min, long max) {
            return (int) ((num - min) * len / (max - min));
        }
}
