package com.lingjian_3;

import java.util.Stack;

/**
 * @description: 仅用栈实现队列
 * @author: Ling Jian
 * @date: 2019-12-17 16:33
 **/
public class TwoStackQueueDemo {
    public static void main(String[] args) {
        TwoStackQueue tsq=new TwoStackQueue();
        tsq.push(1);
        tsq.push(2);
        tsq.push(3);

        System.out.println(tsq.peek());

        System.out.println(tsq.poll());
        System.out.println(tsq.poll());

        tsq.push(4);
        tsq.push(5);

        System.out.println(tsq.peek());


        System.out.println(tsq.poll());
        System.out.println(tsq.poll());
        System.out.println(tsq.poll());
    }


}

class TwoStackQueue{
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackQueue() {
        stackPush =new Stack<>();
        stackPop=new Stack<>();
    }

    public void push(int obj){
        stackPush.push(obj);
        dao();
    }

    public int poll(){
        if(stackPop.isEmpty()&&stackPush.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        dao();
        return stackPop.pop();
    }

    public int peek(){
        if(stackPop.isEmpty()&&stackPush.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        dao();
        return stackPop.peek();
    }

    public void dao(){
        if(!stackPop.isEmpty()){
            return;
        }
        while(!stackPush.isEmpty()){
            stackPop.push(stackPush.pop());
        }
    }
}
