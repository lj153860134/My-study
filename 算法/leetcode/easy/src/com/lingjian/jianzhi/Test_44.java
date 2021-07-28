package com.lingjian.jianzhi;

/**
 * @description: 数字以0123456789101112131415…的格式序列化到一个字符序列中
 *               在这个序列中，第5位（从下标0开始计数）是5
 *               第13位是1，第19位是4，等等
 *               请写一个函数，求任意第n位对应的数字
 * @author: Ling Jian
 * @date: 2020-07-03 17:06
 **/
public class Test_44 {
    public static void main(String[] args) {
        int n = 1000;
        int res = findNthDigit(n);
        int res1 = findNthDigit1(n);

        System.out.println(res);
        System.out.println(res1);
    }
    public static int findNthDigit(int n) {
        if(n<10){
            return n;
        }
        int a=n-9;
        long temp=10;
        int count=2;
        long num1=180;
       while(a>num1){
           a -= num1;
           count++;
           temp *= 10;
           num1=temp*9*count;
       }

        long num = temp + (a-1)/ count;
        return Long.toString(num).charAt((a-1) % count) - '0';


    }


    //K神版
    public static int findNthDigit1(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

}
