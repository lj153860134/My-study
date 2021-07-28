package com.lingjian.leetcode;

import java.util.Stack;

/**
 * @description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串
 *               判断字符串是否有效 有效字符串需满足：
 *               左括号必须用相同类型的右括号闭合
 *               左括号必须以正确的顺序闭合。
 *               注意空字符串可被认为是有效字符串
 * @author: Ling Jian
 * @date: 2020-07-20 22:18
 **/
public class Test_20 {
    public static void main(String[] args) {
        String s = "{[]}";
        boolean res = isValid(s);
        System.out.println(res);
    }
    public static boolean isValid(String s) {
        if(s==null||s.length()==0){
            return true;

        }
        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <chs.length ; i++) {
            if(stack.isEmpty()){
                stack.push(chs[i]);
            }else if(chs[i]==')'){
                if(stack.peek()!='(') return false;
                else stack.pop();
            }else if(chs[i]==']'){
                if(stack.peek()!='[') return false;
                else stack.pop();
            }else if(chs[i]=='}') {
                if(stack.peek()!='{') return false;
                else stack.pop();
            }else{
                stack.push(chs[i]);
            }
        }
        return stack.isEmpty();
    }

}
