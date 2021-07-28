package com.lingjian_1;


import java.util.Scanner;

/**
 * @description: 用数组模拟大小固定的栈
 * @author: Ling Jian
 * @date: 2019-12-17 14:47
 **/
public class ArrayStackDemo {
    public static void main(String[] args) {
        MyArrayStack as=new MyArrayStack(5); //设置为5 其队列的有效数据长度为4
        Scanner sc=new Scanner(System.in);
        char key=' ';    //接收用户的输入
        boolean loop=true;
        while(loop) {
            System.out.println("s(show): 显示栈");
            System.out.println("a(add): 添加数据入栈");
            System.out.println("g(get): 取出数据出栈");
            System.out.println("h(head): 查看栈顶数据");
            System.out.println("c(count): 查看栈的数据个数");
            System.out.println("e(exit): 退出程序");
            System.out.println("请输入你的选择");
            key=sc.next().charAt(0);
            switch(key){
                case 's':
                    as.printStack();
                    break;
                case 'a':
                    System.out.println("请输入要添加的数据：");
                    int data=sc.nextInt();
                    as.push(data);
                    break;
                case 'g':
                    try {
                        int result=as.pop();
                        System.out.println("获得的数据为: "+result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result=as.peek();
                        System.out.println("该队列的头部数据为: "+result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'c':
                    int count=as.getCount();
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

class MyArrayStack{
    private int maxSize;
    private int[] stack;
    int index;    //指向入栈数据的位置

    public MyArrayStack(int maxSize) {
        this.maxSize=maxSize;
        stack = new int[maxSize];
        index=0;
    }

    public void push(int obj){
        if(isFull()){
            System.out.println("The stack is full");
        }
        stack[index++]=obj;
    }

    public int pop(){
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException("The stack is empty");
        }
        return stack[--index];
    }

    public int peek(){
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException("The stack is empty");
        }
        return stack[index-1];
    }

    public void printStack(){
        if(isEmpty()){
            System.out.println("The stack is empty");
            return;
        }
        for (int i = 0; i <index ; i++) {
            if(i==0){
                System.out.print("["+stack[i]);
            }else{
                System.out.print(", "+stack[i]);
            }
        }
        System.out.println("]");
    }

    public int getCount(){
        return index;
    }

    public boolean isEmpty(){
        return index==0;
    }

    public boolean isFull(){
        return index==maxSize;
    }
}
