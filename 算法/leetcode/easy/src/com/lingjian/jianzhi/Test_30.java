package com.lingjian.jianzhi;

import java.util.Stack;

/**
 * @description: 定义栈的数据结构
 *               请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中
 *               调用 min、push 及 pop 的时间复杂度都是 O(1)
 * @author: Ling Jian
 * @date: 2020-06-27 15:10
 **/
public class Test_30 {
    public static void main(String[] args) {
        MinStack stack = new MinStack();

    }
    static class  MinStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin ;


        public MinStack() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int x) {
            if(stackMin.isEmpty()){
                stackMin.push(x);
            }else if(x<=stackMin.peek()){
                stackMin.push(x);
            }
            stackData.push(x);

        }

        public void pop() {
            if(stackData.isEmpty()){
                throw  new RuntimeException("The Stack is Empty");
            }
            int value = stackData.pop();
            if(value==this.min()){
                stackMin.pop();
            }
        }

        public int top() {
            if(stackData.isEmpty()){
                throw  new RuntimeException("The Stack is Empty");
            }
            return stackData.peek();

        }

        public int min() {
            return stackMin.peek();
        }
    }
}
