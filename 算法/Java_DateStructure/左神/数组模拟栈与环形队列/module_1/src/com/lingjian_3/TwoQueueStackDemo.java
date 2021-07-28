package com.lingjian_3;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @description: 仅用队列实现栈
 * @author: Ling Jian
 * @date: 2019-12-17 16:17
 **/
public class TwoQueueStackDemo {
    public static void main(String[] args) {
        TwoQueueStack tws=new TwoQueueStack();
        //入栈
        tws.push(1);
        tws.push(2);
        tws.push(3);

        //获取栈顶数据
        System.out.println(tws.peek());
        //出栈
        System.out.println(tws.pop());

        //获取栈顶数据
        System.out.println(tws.peek());
        //出栈
        System.out.println(tws.pop());

        //获取栈顶数据
        System.out.println(tws.peek());
        //出栈
        System.out.println(tws.pop());

        //获取栈顶数据
        System.out.println(tws.peek());
        //出栈
        System.out.println(tws.pop());


    }
}

class TwoQueueStack{
    private Queue<Integer> data;
    private Queue<Integer> help;

    public TwoQueueStack() {
        data =new LinkedList<Integer>();
        help=new LinkedList<Integer>();
    }

    public void push(int obj){
        data.add(obj);
    }

    public int pop(){
        if(data.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        while(data.size()>1){
            help.add(data.poll());
        }
        int res= data.poll();
        swap();
        return res;
    }

    public int peek(){
        if(data.isEmpty()){
            throw new RuntimeException("Stack is enpty");
        }
        while(data.size()>1){
            help.add(data.poll());
        }
        int res= data.poll();
        help.add(res);
        swap();
        return res;
    }

    public void swap(){
        Queue<Integer> temp=help;
        help= data;
        data =temp;
    }
}
