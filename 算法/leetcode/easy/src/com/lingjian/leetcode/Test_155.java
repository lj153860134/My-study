package com.lingjian.leetcode;

import java.util.ArrayDeque;

/**
 * @description: 设计一个支持 push pop top 操作
 *               并能在常数时间内检索到最小元素的栈
 *               push(x) —— 将元素 x 推入栈中
 *               pop() —— 删除栈顶的元素
 *               top() —— 获取栈顶元素
 *               getMin() —— 检索栈中的最小元素。
 * @author: Ling Jian
 * @date: 2020-08-25 15:57
 **/
public class Test_155 {
    class MinStack{
        private ArrayDeque<Integer> stack;
        private ArrayDeque<Integer> min;

        public MinStack() {
            stack = new ArrayDeque<>();
            min = new ArrayDeque<>();
        }

        public void push(int x) {
            if(min.isEmpty()){
                min.push(x);
            }else if(x<=min.peek()){
                min.push(x);
            }else{
                min.push(min.peek());
            }
            stack.push(x);
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }

    }
}
