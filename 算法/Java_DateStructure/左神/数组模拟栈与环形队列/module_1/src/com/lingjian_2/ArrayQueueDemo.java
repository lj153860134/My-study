package com.lingjian_2;

import java.util.Scanner;

/**
 * @description: 用数组模拟大小固定的环形队列
 * @author: Ling Jian
 * @date: 2019-12-17 14:52
 **/
public class ArrayQueueDemo {
    public static void main(String[] args) {
        MyArrayQueue aq=new MyArrayQueue(5); //设置为5 其队列的有效数据长度为4
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
                    aq.printQueue();
                    break;
                case 'a':
                    System.out.println("请输入要添加的数据：");
                    int data=sc.nextInt();
                    aq.push(data);
                    break;
                case 'g':
                    try {
                        int result=aq.poll();
                        System.out.println("获得的数据为: "+result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result=aq.peek();
                        System.out.println("该队列的头部数据为: "+result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'c':
                    int count=aq.getCount();
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


class MyArrayQueue{
    private int maxSize;
    private int[] queue;
    private int start;  //出队列应该要删除的位置
    private int end;    //入队列应该要添加的位置
    private int size;   //判断队列总的长度

    public MyArrayQueue(int maxSize) {
        this.maxSize=maxSize;
        queue=new int[maxSize];
        start=0;
        end=0;
        size=0;
    }

    public void push(int obj){
        if(isFull()){
            System.out.println("The queue is full");
            return;
        }
        size++;
        queue[end]=obj;
        end=end==maxSize-1?0:end+1;

    }

    public int poll(){
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        size--;
        int temp=start;
        start=start==maxSize-1?0:start+1;
        return queue[temp];
    }

    public int peek(){
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException("The queue is empty");

        }
        return queue[start];
    }

    public int getCount(){
        return size;
    }

    public void printQueue(){
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return;
        }
        for (int i = start; i <start+getCount(); i++) {
        if (i == start)
            System.out.print("[" + queue[i%maxSize]);
        else {
            System.out.print("," + queue[i%maxSize]);
        }
    }
        System.out.println("]");
    }

    public boolean isFull(){
        return size==maxSize;
    }

    public boolean isEmpty(){
        return size==0;
    }


}
