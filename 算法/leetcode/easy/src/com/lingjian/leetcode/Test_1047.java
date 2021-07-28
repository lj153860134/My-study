package com.lingjian.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @description: 给出由小写字母组成的字符串 S
 * 重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * @date: 2020-09-16 11:06
 **/
public class Test_1047 {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
        System.out.println(removeDuplicates2(s));
//        System.out.println(removeDuplicates3(s));
    }


    //利用栈
    public static String removeDuplicates(String S) {
        if(S==null||S.length()<=1){
            return S;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
//        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <S.length() ; i++) {
            if(!stack.isEmpty()&&S.charAt(i)==stack.peek()){
                stack.pop();
            }else {
                stack.push(S.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
//            System.out.println(character);
            sb.append(character);
        }
        return sb.toString();
    }
    public static String removeDuplicates2(String S) {
        /* 只需删除重复项即可，因此可以使用栈实现
         * 每次添加时比较是否与栈顶元素相同
         *   - 若相同则删除栈顶元素且不插入
         *   - 若不相同则插入新元素
         * 时间复杂度：O(N)
         * 空间复杂度：O(N)
         */
        char[] s = S.toCharArray();
        int len = s.length;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty() || s[i] != stack.peek()) {
                stack.push(s[i]);
            } else {
                stack.pop();
            }
        }
        /* 数据的展示可以继续优化 */
        StringBuilder str = new StringBuilder();
        for (Character c : stack) {
//            System.out.println(c);
            str.append(c);
        }
        return str.toString();

    }
    
    //数组双指针
    public static String removeDuplicates3(String S) {
        if(S==null||S.length()<=1){
            return S;
        }
        char[] res = new char[S.length() + 1];
        char[] chs = S.toCharArray();
        int i=0;

        for (char ch : chs) {
            if(i==0){
                res[i++] = ch;
            }else if(res[i-1]==ch){
                i--;
            }else{
                res[i++] = ch;
            }
        }
        return new String(res,0,i);
    }
}
