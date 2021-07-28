package com.lingjian.jianzhi;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @description: 给定一个数组nums和滑动窗口的大小k
 * 请找出所有滑动窗口里的最大值
 * @author: Ling Jian
 * @date: 2020-07-07 16:36
 **/
public class Test_59_1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 6, 4, 8, 2, 10, 23, 3, 7, 89};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
        res = maxSlidingWindow1(nums, k);
        System.out.println(Arrays.toString(res));
        res = maxSlidingWindow2(nums, k);
        System.out.println(Arrays.toString(res));


    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        int right = 0;
        int index = 0;
        while (right < k - 1) {
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[right]) {
                list.pollLast();
            }
            list.add(right++);
        }

        while (right < nums.length) {
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[right]) {
                list.pollLast();
            }
            list.add(right++);
            res[index++] = nums[list.peek()];
            if (list.peek() == left) {
                list.poll();
            }
            left++;
        }
        return res;
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int index = 0;
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[i]) {
                list.pollLast();
            }
            list.add(i);

            if (i >= k - 1) {
                res[index++] = nums[list.peek()];
            }

            if (list.peek() == i - k) {
                list.poll();
            }
        }

        return res;
    }

    //滑动窗口练习专用
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return new int[0];
        }
        if(k==0){
            return nums;
        }
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        for (int i = 0; i <nums.length ; i++) {
            while(!list.isEmpty()&&nums[list.peekLast()]<=nums[i]){
                list.pollLast();
            }
            list.addLast(i);
            if(i>=k-1){
                res[i - k + 1] = nums[list.peekFirst()];
            }
            if(list.peekFirst()==i-k){
                list.pollFirst();
            }
        }
        return res;
    }

}
