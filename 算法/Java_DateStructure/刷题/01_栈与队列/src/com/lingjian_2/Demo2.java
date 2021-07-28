package com.lingjian_2;

import java.util.Stack;

/**
 * @description: 仅用递归函数和一个栈逆序一个栈
 * @author: Ling Jian
 * @date: 2020-03-07 09:08
 **/
public class Demo2 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverse(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }

    //将栈底的元素返回并移除
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        //一开始判断栈是否为空
        //只要进入递归 就不会进来判断了 因为进递归的条件是不为空
        //因为在主程序中会判断是否为空 这里可以不用判断
//        if(stack.isEmpty()){
//            throw new RuntimeException("栈为空 无法逆序");
//        }
        int result=stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }else{
            int i = getAndRemoveLastElement(stack);
            reverse(stack);
            stack.push(i);
        }
    }


}
