package com.lingjian.jianzhi;

/**
 * @description: 实现函数double Power(double base, int exponent)
 *               求base的exponent次方。不得使用库函数，同时不需要考虑大数问题
 * @author: Ling Jian
 * @date: 2020-06-22 16:07
 **/
public class Test_16 {
    public static void main(String[] args) {
        double x=2.1;
        int n=3;
        double res = myPow(x, n);
        System.out.println(res);

    }
    public static double myPow(double x, int n) {
        if(x==1){
            return 1;
        }
        long b=n;
        double res=1;
        long m = Math.abs(b);
        for (long i = 0; i <m ; i++) {
            res *= x;
        }
        if(n<0){
            return (double)1 / res;
        }else{
            return (double)res;
        }


    }
}
