package com.lingjian_1;

import java.util.Stack;

/**
 * @description: 实现一个特殊的栈 有基本功能 再返回栈中最小元素的操作
 *               pop push getMin操作的时间复杂度为O(1)
 * @author: Ling Jian
 * @date: 2020-02-29 21:42
 **/
public class Demo1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Demo1() {
        this.stackData=new Stack<>();
        this.stackMin=new Stack<>();
    }

    /**
     * 入栈
     * @param data
     */
    public void push(int data) {
        if(stackMin.isEmpty()||data<=getMin()){
            stackMin.push(data);
        }
        stackData.push(data);
    }

    public int pop(){
        if(stackData.isEmpty()){
            throw new RuntimeException("the stack is enpty ");
        }
        int value = stackData.pop();
        if (value == getMin()) {
            stackMin.pop();
        }
        return value;
    }
    /**
     * 栈中最小值
     * @return
     */
    public int getMin(){
        if(stackMin.isEmpty())
            throw new RuntimeException("the stack is empty");
        int min=stackMin.peek();
        return min;
    }
}