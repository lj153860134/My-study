package com.lingjian.jianzhi;

/**
 * @description: 约瑟夫问题
 *               0,1,,n-1这n个数字排成一个圆圈
 *               从数字0开始，每次从这个圆圈里删除第m个数字
 *               求出这个圆圈里剩下的最后一个数字
 * @author: Ling Jian
 * @date: 2020-07-03 14:38
 **/
public class Test_62 {
    public static void main(String[] args) {
        int n=2;
        int m=3;
        int res = lastRemaining(n, m);
        System.out.println(res);

    }

    public static int lastRemaining(int n, int m) {
        int num=0;
        for(int i=2;i<=n;i++){
            num=(num+m)%i;
        }
        return num+1;
    }
}
