package com.lingjian.jianzhi;

import java.util.Stack;

/**
 * @description: 输入两个整数序列
 *               第一个序列表示栈的压入顺序
 *               请判断第二个序列是否为该栈的弹出顺序
 *               假设压入栈的所有数字均不相等
 * @author: Ling Jian
 * @date: 2020-06-27 15:55
 **/
public class Test_31 {
    public static void main(String[] args) {
        int[] pushed=new int[]{1,2,3,4,5};
        int[] popped=new int[]{4,5,3,1,2};
        boolean flag = validateStackSequences(pushed, popped);
        System.out.println(flag);
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        for (int num : pushed) {
            stack.push(num);
            while(!stack.isEmpty()&&stack.peek()==popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();


    }
}
