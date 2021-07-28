package com.lingjian.leetcode;

import java.util.Stack;

/**
 * @description:
 *    给定 n 个非负整数，用来表示柱状图中各个柱子的高度
 *    每个柱子彼此相邻，且宽度为 1 。
 *    求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * @author: Ling Jian
 * @date: 2020-09-16 14:31
 **/
public class Test_84 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        int res = largestRectangleArea(nums);
        System.out.println(res);
    }

    public static int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0){
            return 0;
        }
        if(heights.length==1){
            return heights[0];
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <heights.length ; i++) {
            while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                int height = heights[stack.pop()];
//                while (!stack.isEmpty() && heights[stack.peek()] == height) {
//                    stack.pop();
//                }
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                int length = right - left - 1;
                max = Math.max(height * length, max);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int height = heights[stack.pop()];
//            while (!stack.isEmpty() && heights[stack.peek()] == height) {
//                stack.pop();
//            }
            int left = stack.isEmpty() ? -1 : stack.peek();
            int right=heights.length;
            int length = right - left - 1;
            max = Math.max(height * length, max);
        }
        return max;
    }
}
