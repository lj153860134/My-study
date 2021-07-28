package com.lingjian.queue;

/**
 * @description: 数组实现环形队列
 * @author: Ling Jian
 * @date: 2020-05-06 15:38
 **/
public class ArrayQueueDemo2 {
    public static void main(String[] args) {
        Queue2 queue = new Queue2(3);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.poll();
        queue.poll();
        queue.push(4);
        System.out.println(queue.count());
        queue.show();

    }
}


class Queue2 {
    private int[] arr;
    private int maxSize;
    private int start;  //出队列数据的位置
    private int end;   //入队列数据的位置
    private int size;  //队列中数据的个数 环形队列需要


    public Queue2(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        start = 0;
        end = 0;
    }

    public boolean isFull() {
        return size==maxSize;
    }

    public boolean isEmpty() {
        return size==0;
    }

    //入队列
    public void push(int data) {
        if (isFull()) {
            System.out.println("The queue is full");
            return;
        }
        size++;
        arr[end] = data;
        end=end+1==maxSize?0:end+1;
    }

    //出队列
    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty");
        }
        size--;
        int result= arr[start];
        start=start+1==maxSize?0:start+1;
        return result;
    }


    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty");
        }
        return arr[start];
    }

    public int count() {
        return size;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("[ ]");
            return;
        }
        for (int i = start; i < start+size; i++) {
            if (i == start) {
                System.out.print("["+arr[i%maxSize]);
            } else {
                System.out.print(","+arr[i%maxSize] );
            }
        }
        System.out.println("]");

    }
}
