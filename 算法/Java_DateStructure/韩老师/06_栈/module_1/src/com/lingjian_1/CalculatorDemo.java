package com.lingjian_1;

import java.sql.SQLOutput;

/**
 * @author lingjian
 * @date 2019/12/3 - 10:23 上午
 */
public class CalculatorDemo {
    public static void main(String[] args) {
        String expression="1+2*3-100/2";
        MyStack numStack=new MyStack(20);
        MyStack oprStack=new MyStack(20);
        int index=0;  //表达式的索引
        char ch=' ';   //用于存储当前的表达式的单个字符
        int num1=0;    //num1 num2用来存储 数栈弹出的数据
        int num2=0;
        int oper=0;
        int res=0;     //用来保存运算结束后的结果
        String keepNum=""; //用来处理多位数
        while(true){
            //得到表达式的单个字符（多位数会计算错误）
            ch=expression.substring(index,index+1).charAt(0);
            if(isOpe(ch)){ //判断为操作符
                if(oprStack.isEmpty()){ //操作符栈为空
                    oprStack.push(ch);
                }else{ //操作符栈不为空
                    //判断操作符的栈顶符号与ch进行比较优先级
                    while(!oprStack.isEmpty()&&priority(ch)<=priority(oprStack.peek())){
                        num1=numStack.pop();
                        num2=numStack.pop();
                        oper=oprStack.pop();
                        res=operation(num1,num2,oper);
                        numStack.push(res);
                    }
                    oprStack.push(ch);

                }
            }else{
//                numStack.push(ch-48); // 如果这里是单个数字
                                        // 注意ch-48 字符与实际代表的值差48
                //处理多位数字
                keepNum+=ch;
              if(index==expression.length()-1){
                  numStack.push(Integer.parseInt(keepNum));
              }else{
                  if(isOpe(expression.substring(index+1,index+2).charAt(0))){
                      numStack.push(Integer.parseInt(keepNum));
                      //重要！！！！！！！！
                      keepNum="";
                  }
              }
            }
            index++;
            if(index==expression.length())   //当索引扫描完毕 退出循环
                break;
        }
        while(!oprStack.isEmpty()){  //判断符号栈是否为空
            num1=numStack.pop();
            num2=numStack.pop();
            oper=oprStack.pop();
            res=operation(num1,num2,oper);

            numStack.push(res);
            if(res==Integer.MAX_VALUE)
                break;
        }
        //当符号栈为空说明计算完成
        //数栈中只有一个数据那就是最终的结果
        res=numStack.pop();
        if(res==Integer.MAX_VALUE){
            System.out.println("error");
        }else {
            System.out.println(res);
        }

    }

    /**
     * 判断符号的优先级
     * @param ch
     * @return
     */
    public static int priority(int ch){
        if(ch=='*'||ch=='/')
            return 1;
        if(ch=='+'||ch=='-')
            return 0;
        return -1;  // 默认现在只有+-*/
    }

    /**
     * 判断是否为操作符
     * @param ch
     * @return
     */
    public static boolean isOpe(int ch){
        return ch=='*'||ch=='/'||ch=='+'||ch=='-';
    }

    /**
     * 对操作数进行计算
     * @param num1
     * @param num2
     * @param ch
     * @return
     */
    public static int operation(int num1,int num2,int ch){
        if(!isOpe(ch)){
            throw new RuntimeException("操作符有误");
        }
        int res=0;
        switch(ch){
            case'+' :
            res= num1+num2;
                break;
            case '-':
                res= num2-num1;
                break;
            case '*':
                res= num1*num2;
                break;
            case '/':
                if(num1==0)
                    return Integer.MAX_VALUE;
                res= num2/num1;
                break;
            default:
                break;
        }
        return res;
    }
}

class MyStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    //构造器
    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判断栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int data) {
        if (isFull()) {
            System.out.println("栈满 无法添加数据");
            return;
        }
        stack[++top] = data;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空 无法弹出数据");
        }
        return stack[top--];
    }

    //显示栈顶数据 并不出栈
    public  int peek(){
        if (isEmpty()) {
            throw new RuntimeException("栈空 无法显示栈顶数据");
        }
        return stack[top];
    }

    //遍历栈数据
    public void printStack() {
        if (isEmpty()) {
            System.out.println("栈空 无法打印数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            if (i == top)
                System.out.print("[ ");
            System.out.print(+stack[i] + ", ");
        }
        System.out.println("]");
    }
}