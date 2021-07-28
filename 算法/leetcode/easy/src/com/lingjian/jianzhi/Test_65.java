package com.lingjian.jianzhi;

/**
 * @description: 写一个函数 求两个整数之和
 *               要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * @author: Ling Jian
 * @date: 2020-06-30 22:41
 **/
public class Test_65 {
    public static void main(String[] args) {
        int res = add(1, 2);
        System.out.println(res);

    }

    public static int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;

        
    }
}
