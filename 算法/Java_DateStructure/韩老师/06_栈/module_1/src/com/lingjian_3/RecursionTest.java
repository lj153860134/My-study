package com.lingjian_3;

/**
 * @description: 递归测试
 * @author: Ling Jian
 * @date: 2019-12-05 09:42
 **/
public class RecursionTest {
    public static void main(String[] args) {
        test(5);
    }

    public static void test(int n){
       if(n>1){
           test(n-1);
       }    //这里没有else
           System.out.println(n);

    }
}
