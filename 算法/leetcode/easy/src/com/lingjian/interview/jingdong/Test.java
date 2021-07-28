package com.lingjian.interview.jingdong;


import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-08-06 19:24
 **/
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double res = solution(n);
//        System.out.println(res);
        System.out.printf("%.4f\n",res);
        System.out.println(solution1(n));

    }

    public static double solution(int n){

        double num1 = 0;
        double num2=0;
        double sum = 0;
        for (int i = 1; i <n+1 ; i++) {
            num1 = 1.0 / ((i *2-1)*5);
            num2=-1.0/((i*2)*5);
            sum =sum+ num1+num2;
        }

        return sum;

    }

    public static String solution1(int n) {

        double sum = 0;
        int mul = 1;
        for (int i = 1; i < 2 * n + 1; ++i) {
            sum += (double) mul / (5 * i);
            mul *= -1;
        }
        String format = new DecimalFormat("#.0000").format(sum);
        return format;
    }
}
