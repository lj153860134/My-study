package com.lingjian_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 利用栈 输入后缀表达式
 * 计算出结果 完成你逆波兰计算器
 * @author: lingjian
 * @date: 2019-12-04 14:06
 **/
public class PolandCalculatorDemo {
    public static void main(String[] args) {
        //思考题 直接中缀表达式（无空格） 然后添加到list中
        //将String转换成char数组 进行遍历 还要考虑多位数
        //先定义中缀表达式（用空格隔开）
//        String infixExpression="1 + ( ( 2 + 3 ) * 4 ) - 5 ";
        String infixExpression="48 * ( ( 70 - 65 ) - 43 ) + 8 * 1 ";
        //得到中缀表达式的List集合
        List<String> list = getList(infixExpression);
        System.out.println(list);
        //中缀表达式转后缀表达式
        String postfixExpression =transform(list) ;
        list=getList(postfixExpression);
        System.out.println(list);
        System.out.println(calculate(list));


    }
    /**
    * @description: 中缀表达式转后缀表达式
    * @param: [s]
    * @return: java.lang.String
    * @author: lingjian
    * @date: 2019/12/4 3:33 下午
    */
    public static String transform(List<String> list){
        String str="";
        Stack<String> stack=new Stack();
        StringBuilder sb=new StringBuilder();
        for(String item:list){
            if(item.matches("\\d+")){ //判断是否为多位数
                sb.append(item+" ");      //如果是数字 直接添加sb中
            }else{
                if(item.equals("(")){
                    stack.push(item);   //若是左括号  直接添加到栈里
                }
                else if(item.equals(")")){
                    while(!(str=stack.pop()).equals("(")){ //将栈里左括号与右括号之间
                                                           //所有的操作符出栈（还要消除左括号）
                        sb.append(str+" ");
                    }
                }else{
                    while (true) {
                        if (stack.isEmpty()||stack.peek().equals("(")) {   //判断栈是否为空栈或者碰到左括号
                            break;
                        }
                        while (!stack.isEmpty() && priority(item) <= priority(stack.peek())) {
                            str = stack.pop();
                            sb.append(str + " "); //因为已经出栈  所以还要判断是否为空栈
                        }
                    }

                    stack.push(item);  //将该运算符放入栈中
                }
            }
        }
        str=stack.pop(); //最后stack中还会有一个操作符
        sb.append(str+" ");
        return sb.toString();


    }


    /**
     * @description: 将一个用空格隔开的String中的数据与运算符放入ArrayList中
     * @param: [s]
     * @return: java.util.List<java.lang.String>
     * @author: lingjian
     * @date: 2019/12/4 3:00 下午
     */
    public static List<String> getList(String s) {
        List<String> list = new ArrayList<>();
        //将逆波兰表达式 用空格分割 放入list中
        String[] strs = s.split(" ");
        for (String str : strs) {
            list.add(str);
        }
        return list;
    }

    /**
     * @description: 对逆波兰表达式计算 得出结果
     * @param: [list]
     * @return: int
     * @author: lingjian
     * @date: 2019/12/4 3:04 下午
     */

    public static int calculate(List<String> list) {
        //定义会用到的变量
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        //定义一个栈
        Stack<String> stack = new Stack();
        for (String item : list) {
            //用正则表达式判断为多位数
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                switch (item) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res=num1-num2;
                        break;
                    case "*":
                        res=num1*num2;
                        break;
                    case "/":
                        res=num1/num2;
                        break;
                    default:
                        throw new RuntimeException("操作符有误");
                }
                stack.push(String.valueOf(res));
            }
        }
        return(Integer.parseInt(stack.pop()));

    }

    public static int priority(String s){
        if(s.equals("*")||s.equals("/"))
            return 1;
        if(s.equals("+")||s.equals("-"))
            return 0;
        return 2;  // 默认现在只有+-*/
    }
}
