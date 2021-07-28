package com.lingjian.leetcode;

/**
 * @description: 给定两个整数，被除数 dividend 和除数 divisor
 *               将两数相除，要求不使用乘法、除法和 mod 运算符
 *               返回被除数 dividend 除以除数 divisor 得到的商
 * @author: Ling Jian
 * @date: 2020-06-13 17:27
 **/
public class Test_29 {
    public static void main(String[] args) {
        int dividend=10;
        int divisor=3;
        int res = divide(dividend, divisor);
        System.out.println(res);

    }

    public static int divide(int dividend, int divisor) {
        boolean flag=true;
        if(((dividend>>>31)^(divisor>>>31))==1){
            flag=false;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int[] nums = new int[dividend+1];
        int count=0;
        for (int i =divisor; i <nums.length ; i+=divisor) {
            count++;
        }
        if(flag){
            return count;
        }else{
            return -count;
        }

    }

}


