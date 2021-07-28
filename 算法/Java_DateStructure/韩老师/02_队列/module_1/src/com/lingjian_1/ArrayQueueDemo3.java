package com.lingjian_1;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019/11/27 - 9:11 上午
 */

/*
*   数组模拟循环队列(左神）
*   多添加一个size（表示队列中数据的个数）
* */
public class ArrayQueueDemo3 {
    public static void main(String[] args) {
        ArrayQueue3 aq=new ArrayQueue3(5); //设置为5 其队列的有效数据长度为4
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
                    aq.printQuene();
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

class ArrayQueue3{
    private int maxSize;
    private int start;   //指向出队列数据的位置
    private int end;     //指向入队列数据的位置
    private int size;    //队列中数据的个数
                         //多一个变量 方便很多
    private int[] arr;

    public ArrayQueue3(int maxSize) {
        this.maxSize = maxSize;
        this.start =0;
        this.end =0;
        this.size=0;
        this.arr=new int[maxSize];
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return size==0;  //队列为空的条件
    }

    //判断队列是否为满
    public boolean isFull() {
        return size==maxSize;//队列满的条件
    }

    //添加数据到队列（入队列）
    public void push(int data){
        if(isFull()) {
            System.out.println("队列已满 无法添加数据");
            return;
        }
        size++;
        arr[end]=data;
        end=end==maxSize-1?0:end+1;
    }

    //获取队列的数据（出队列）
    public int poll(){
        if(isEmpty())
            throw new RuntimeException("队列为空 无法获取数据");
        size--;
        int result=arr[start];
       start=start==maxSize-1?0:start+1;
        return result;
    }

    //获取队列数据的长度
    public int getCount(){
        return size;
    }

    //显示队列的头数据（不是取出数据）
    public int peek(){
        if(isEmpty())
            throw new RuntimeException("队列为空 无法获取头数据");
        return arr[start];
    }

    //获取队列的全部数据
    public void printQuene() {
        if (isEmpty()) {
            System.out.println("队列为空 无法获取全部数据");
            return;
        }
        for (int i = start; i < start+size; i++) {
            if (i == start)
                System.out.print("[" + arr[i%maxSize]);
            else {
                System.out.print("," + arr[i%maxSize]);
            }
        }
        System.out.println("]");
    }

}
