package com.lingjian.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description: 给定一个只包含 '(' 和 ')' 的字符串
 * 找出最长的包含有效括号的子串的长度
 * @author: Ling Jian
 * @date: 2020-07-04 15:40
 **/
public class Test_32 {
    public static void main(String[] args) {

        String s = "(())()(";
        int res = longestValidParentheses1(s);
        System.out.println(res);


    }

    //栈的思路 （要在栈顶预先放入一个-1 作为参照）
    public static int longestValidParentheses1(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
//        这里一定要先放入-1;
        stack.push(-1);
        char[] chs = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                res = Math.max(res, i - stack.peek());

            }



        }
        return res;
    }




    //栈转换成数组思路
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int[] nums = stringToArr(s);
        System.out.println(Arrays.toString(nums));
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count = 0;
            } else {
                count++;
            }
            res = Math.max(res, count);
        }


        return res;
    }

    public static int[] stringToArr(String s) {
        char[] chs = s.toCharArray();
        int[] res = new int[chs.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                stack.push(i);
            } else if (stack.isEmpty() || chs[stack.peek()] == ')') {
                stack.push(i);
            } else {
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = 1;
        }
        return res;


    }


    //利用双指针
    public static int longestValidParentheses2(String s){
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int left=0;
        int right=0;
        int res=0;
        char[] chs = s.toCharArray();

        for (int i = 0; i <chs.length ; i++) {
            if(chs[i]=='('){
                left++;
            }else{
                right++;

            }

            if(left==right){
                res = Math.max(res, 2*left);
            }else if(right>left){
                right=0;
                left=0;
            }
        }
        //必须倒一下 "(()))"计算不到left会一直小于right
        right=0;
        left=0;
        for (int i = chs.length-1; i >=0 ; i--) {
            if(chs[i]==')'){
                left++;
            }else{
                right++;

            }

            if(left==right){
                res = Math.max(res, 2*left);
            }else if(right>left){
                right=0;
                left=0;
            }
        }
        return res;
    }



}
