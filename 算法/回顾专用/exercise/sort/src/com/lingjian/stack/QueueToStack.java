package com.lingjian.stack;


import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 队列实现栈
 * @author: Ling Jian
 * @date: 2020-05-09 16:20
 **/
public class QueueToStack {
    private Queue<Integer> data;
    private Queue<Integer> help;

    public QueueToStack() {
        this.data = new LinkedList<Integer>();
        this.help = new LinkedList<Integer>();
    }

    public void swap(){
        LinkedList<Integer> temp = (LinkedList) data;
        data=help;
        help=temp;

    }

    public void push(int num) {
        data.offer(num);
    }

    public int pop(){
        if(data.isEmpty()){
            throw new RuntimeException("The stack is empty");
        }
        while (data.size() > 1) {
            help.offer(data.poll());
        }
        int res = data.poll();
        swap();
        return res;
    }

    public int peek(){
        if (data.isEmpty()) {
            throw new RuntimeException("The stack is empty");
        }
        while (data.size() > 1) {
            help.offer(data.poll());
        }
        int res = data.poll();
        help.offer(res);
        swap();
        return res;
    }

    @Test
    public void test(){
        QueueToStack qts = new QueueToStack();
        qts.push(1);
        qts.push(2);
        qts.push(3);
        qts.push(4);
        qts.push(5);

        System.out.println(qts.pop());
        System.out.println(qts.peek());
        System.out.println(qts.pop());
        System.out.println(qts.pop());
        System.out.println(qts.pop());
        System.out.println(qts.pop());
    }
}
