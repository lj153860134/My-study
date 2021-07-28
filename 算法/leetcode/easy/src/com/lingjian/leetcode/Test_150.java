package com.lingjian.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @description: 有效的运算符包括 +, -, *, / 。
 * 每个运算对象可以是整数，
 * 也可以是另一个逆波兰表达式。
 * @author: Ling Jian
 * @date: 2020-09-16 15:20
 **/
public class Test_150 {
    public static void main(String[] args) {
        String[] tokens=new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int res = evalRPN(tokens);
        System.out.println(res);
    }

    public static int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        int a;
        int b;
        for (String s : tokens) {
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                a = Integer.parseInt(stack.pop());
                b = Integer.parseInt(stack.pop());
                switch (s){
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(a - b));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }else{
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
