package com.lingjian.queue;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: 使用栈实现队列
 * @author: Ling Jian
 * @date: 2020-05-09 16:34
 **/
public class StackToQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public StackToQueue() {
        stackPush =new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(int num) {
        stackPush.push(num);
        dao();
    }

    public int poll() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("The queue is empty");
        }
        dao();
        return stackPop.pop();
    }

    public int peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("The queue is empty");
        }
        dao();
        return stackPop.peek();

    }


    //可以随时随地的dao
    public void dao(){
        if (!stackPop.isEmpty()) {
            return;
        }
        while (!stackPush.isEmpty()) {
            stackPop.push(stackPush.pop());
        }
    }

    @Test
    public void test() {
        StackToQueue stq = new StackToQueue();
        stq.add(1);
        stq.add(2);
        stq.add(3);
        stq.add(4);
        stq.add(5);

        System.out.println(stq.poll());
        System.out.println(stq.poll());
        System.out.println(stq.peek());
        System.out.println(stq.poll());
        System.out.println(stq.poll());
        System.out.println(stq.poll());
    }
}
