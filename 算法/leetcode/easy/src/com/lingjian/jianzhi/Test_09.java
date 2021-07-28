package com.lingjian.jianzhi;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @description: 用两个栈实现一个队列
 *               队列的声明如下
 *               请实现它的两个函数
 *               appendTail 和 deleteHead
 *               分别完成在队列尾部插入整数和在队列头部删除整数的功能
 *               (若队列中没有元素，deleteHead 操作返回 -1 )
 * @author: Ling Jian
 * @date: 2020-06-21 17:02
 **/
public class Test_09 {
    public static void main(String[] args) {
        CQueue1 queue = new CQueue1();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        queue.appendTail(4);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

     static class CQueue{
        private Stack<Integer> push;
        private Stack<Integer> pop;


        public CQueue() {
            push = new Stack<>();
            pop = new Stack<>();
        }

        public void appendTail(int value) {
            push.push(value);
            dao();

        }

        public int deleteHead() {
            if(push.isEmpty()&&pop.isEmpty()){
                return -1;
            }
            dao();
            return pop.pop();
        }

        public void dao(){
            if(!pop.isEmpty()){
                return;
            }
            while(!push.isEmpty()){
                pop.push(push.pop());
            }
        }
    }

    static class CQueue1{
        Deque<Integer> A;
        Deque<Integer> B;

        public CQueue1() {
            A= new ArrayDeque<>();
            B = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            A.push(value);

        }

        public int deleteHead() {
            if(!B.isEmpty()) return B.pop();
            if(A.isEmpty()) return -1;
            while(!A.isEmpty()){
                B.push(A.pop());
            }
            return B.pop();
        }

    }
}
