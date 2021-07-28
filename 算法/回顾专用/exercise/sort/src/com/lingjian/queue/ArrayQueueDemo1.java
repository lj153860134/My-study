package com.lingjian.queue;

/**
 * @description: 数组模拟队列（不可循环）
 * @author: Ling Jian
 * @date: 2020-05-06 14:51
 **/
public class ArrayQueueDemo1 {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
//        System.out.println(queue.count());
        queue.show();
        queue.push(1);
        queue.show();
        queue.push(2);
//        queue.show();
        queue.push(3);
//        queue.show();
//        queue.push(4);
//        queue.show();
//        queue.push(5);
        queue.show();
//        System.out.println(queue.count());
//        System.out.println(queue.poll());
//        System.out.println(queue.count());
//        queue.show();
//        System.out.println(queue.count());


    }

}

class Queue {
    private int[] arr;
    private int maxSize;
    private int start;  //出队列数据的位置
    private int end;   //入队列数据的位置
//    private int size;  //队列中数据的个数 循环队列需要


    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        start = 0;
        end = 0;
    }

    public boolean isFull() {
        return end == maxSize;
    }

    public boolean isEmpty() {
        return start == end;
    }

    //入队列
    public void push(int data) {
        if (isFull()) {
            System.out.println("The queue is full");
            return;
        }
        arr[end++] = data;
    }

    //出队列
    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty");
        }
        return arr[start++];
    }


    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty");
        }
        return arr[start];
    }

    public int count() {
        return end - start;
    }

    public void show() {
        if(isEmpty()){
            System.out.println("[ ]");
            return;
        }
        for (int i = start; i <end ; i++) {
            if(i==start){
                System.out.print("["+arr[i]);
            }else {
                System.out.print( ","+arr[i] );
            }
        }
        System.out.println("]");

    }
}


