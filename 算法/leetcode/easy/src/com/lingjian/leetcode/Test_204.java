package com.lingjian.leetcode;

import sun.applet.Main;

/**
 * @description: 统计所有小于非负整数 n 的质数的数量
 * @author: Ling Jian
 * @date: 2020-08-24 23:35
 **/
public class Test_204 {
    public static void main(String[] args) {
        int n=10;
        int res = countPrimes(n);
        System.out.println(res);

    }
    public static int countPrimes(int n) {
        int res=0;
        for (int i =2; i <n ; i++) {
            if(judgePrime(i)){
//                System.out.println(i);
                res++;
            }
        }

        return res;
    }

    public static boolean judgePrime(int n){
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <=sqrt ; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
