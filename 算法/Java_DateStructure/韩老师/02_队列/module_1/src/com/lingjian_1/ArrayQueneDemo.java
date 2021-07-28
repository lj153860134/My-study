package com.lingjian_1;


import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019/11/26 - 10:15 上午
 */

/*
*
*数组模拟队列（缺点 无法复用）
* */
public class ArrayQueneDemo {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(5);
        Scanner sc = new Scanner(System.in);
        char key = ' '; //接收用户的输入
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("a(add): 添加数据");
            System.out.println("g(get): 取出数据");
            System.out.println("h(head): 查看队列头数据");
            System.out.println("e(exit): 退出程序");
            System.out.println("请输入你的选择");
            key = sc.next().charAt(0);
            switch (key) {
                case 's':
                    aq.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入你要添加的数据");
                    int value = sc.nextInt();
                    aq.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res=aq.getQueue();
                        System.out.println(res);
                    } catch (Exception e) {
                        e.printStackTrace();
//                        System.out.println(e.getMessage());
//                        System.out.println(e.toString());
                    }
                    break;

                case 'h':
                    try {
                        int res=aq.headQueue();
                        System.out.println(res);
                    } catch (Exception e) {
                        e.printStackTrace();
//                        System.out.println(e.getMessage());
//                        System.out.println(e.toString());
                    }
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }

}

/*
 * 使用数组模拟队列
 */
class ArrayQueue {
    private int maxSize; //表示数组的最大容量
    private int front;   //指向队列头的前一个位置
    private int rear;   //指向队列尾
    private int[] arr;  //该数据用于存放数据 模拟队列

    //创建队列的构造器

    public ArrayQueue(int MaxSize) {
        this.maxSize = MaxSize;
        this.arr = new int[MaxSize];
        this.front = -1;    //front指向队列头的前一个位置
        this.rear = -1;     //rear指向队列尾（即就是队列的最后一个数据）
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列（入队列）
    public void addQueue(int data) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("The Queue is Full");
            return;
        }
        arr[++rear] = data; //让rear后移 且将数据添加进队列
    }

    //获取队列的数据（出队列）
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            throw new RuntimeException("The Queue is Empty");
        }
        return arr[++front];


    }

    //获取队列的全部数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("The Queue is Empty");
            return;
        }
        for (int i = front+1; i <=rear; i++) {
            if(i==front+1)
                System.out.print("[" + arr[i]);
            else {
                System.out.print("," + arr[i]);
            }
        }
        System.out.println("]");
    }

    //显示队列的头数据（不是取出数据）
    public int headQueue() {
        if (isEmpty())
            throw new RuntimeException("The Queue is Empty");
        return arr[front + 1];
    }
}
