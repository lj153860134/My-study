package cn.lingjian_1;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019/9/26 - 7:34 下午
 */
/*
* 递归求阶乘
* */
public class DiGuiDemo1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter a integer");
        int number=sc.nextInt();
        int result=factorial(number);
        System.out.println(number+"!="+result);
    }

    public static int factorial(int number) {
        if(number==1)
            return 1;
        else
            return number*factorial(number-1);

    }
}
