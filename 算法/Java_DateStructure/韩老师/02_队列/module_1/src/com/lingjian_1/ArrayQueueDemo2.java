package com.lingjian_1;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019/11/27 - 9:11 上午
 */

/*
*   数组模拟循环队列(韩老师）
* */
public class ArrayQueueDemo2 {
    public static void main(String[] args) {
        ArrayQueue2 aq=new ArrayQueue2(5); //设置为5 其队列的有效数据长度为4
        Scanner sc=new Scanner(System.in);
        char key=' ';    //接收用户的输入
        boolean loop=true;
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("a(add): 添加数据");
            System.out.println("g(get): 取出数据");
            System.out.println("h(head): 查看队列头数据");
            System.out.println("c(count): 查看队列的数据个数");
            System.out.println("e(exit): 退出程序");
            System.out.println("请输入你的选择");
            key=sc.next().charAt(0);
            switch(key){
                case 's':
                    aq.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入要添加的数据：");
                    int data=sc.nextInt();
                    aq.addQueue(data);
                    break;
                case 'g':
                    try {
                        int result=aq.getQueue();
                        System.out.println("获得的数据为: "+result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result=aq.headQueue();
                        System.out.println("该队列的头部数据为: "+result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'c':
                    int count=aq.countQueue();
                    System.out.println("该队列的长度为："+count);
                    break;
                case 'e':
                    sc.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
    }

}

class ArrayQueue2{
    private int maxSize;
    private int front;   //指向队列头（就是第一个数据）
    private int rear;    //指向队列尾的后一个位置
    private int[] arr;

    public ArrayQueue2(int maxSize) {
        this.maxSize = maxSize;
        this.front=0;
        this.rear=0;
        this.arr=new int[maxSize];
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return front==rear;  //队列为空的条件
    }

    //判断队列是否为满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;//队列满的条件
    }

    //添加数据到队列（入队列）
    public void addQueue(int data){
        if(isFull()) {
            System.out.println("队列已满 无法添加数据");
            return;
        }
        arr[rear]=data;
        rear=(rear+1)%maxSize;
    }

    //获取队列的数据（出队列）
    public int getQueue(){
        if(isEmpty())
            throw new RuntimeException("队列为空 无法获取数据");
        int result=arr[front];
        front=(front+1)%maxSize;
        return result;
    }

    //获取队列数据的长度
    public int countQueue(){
        return (rear-front+maxSize)%maxSize;
    }

    //显示队列的头数据（不是取出数据）
    public int headQueue(){
        if(isEmpty())
            throw new RuntimeException("队列为空 无法获取头数据");
        return arr[front];
    }

    //获取队列的全部数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空 无法获取全部数据");
            return;
        }
        for (int i = front; i <front+countQueue(); i++) {
            if (i == front)
                System.out.print("[" + arr[i%maxSize]);
            else {
                System.out.print("," + arr[i%maxSize]);
            }
        }
        System.out.println("]");
    }

}
