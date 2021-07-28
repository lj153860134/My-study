package com.lingjian.leetcode;

/**
 * @description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 * @author: Ling Jian
 * @date: 2020-06-12 23:04
 **/
public class Test_07 {
    public static void main(String[] args) {
        int x = 2312321;
        int res = reverseByString(x);
        System.out.println(res);
    }

    //直接计算
    public static int reverse(int x){
        long n=0;
        while (x != 0) {
            n=n*10+x%10;
            x=x/10;
        }
        return (int) (n) == n ? (int) n : 0;
    }

    //用String反转
    public static int reverseByString(int x) {
        String str = String.valueOf(x);
        int flag=1;
        if (x < 0) {
            flag=-1;
            str = str.substring(1);
        }
        try {
            int res=Integer.parseInt(new StringBuilder(str).reverse().toString())*flag;
            return res;
        } catch (Exception e) {
            return 0;
        }
    }
}
