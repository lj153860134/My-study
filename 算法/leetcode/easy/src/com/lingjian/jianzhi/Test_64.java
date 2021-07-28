package com.lingjian.jianzhi;

/**
 * @description: 求 1+2+...+n
 *              要求不能使用乘除法、for、while、if、else
 *              switch、case等关键字及条件判断语句（A?B:C）
 * @author: Ling Jian
 * @date: 2020-07-01 16:36
 **/
public class Test_64 {
    public static void main(String[] args) {
        int n=100;
        int res=sumNums(n);
        System.out.println(res);
    }
    static int res=0;
    public static int sumNums(int n) {
        boolean flag=n>1&&sumNums(n-1)>0;
        res+=n;
        return res;
    }
}
