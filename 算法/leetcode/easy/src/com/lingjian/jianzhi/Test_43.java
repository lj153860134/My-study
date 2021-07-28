package com.lingjian.jianzhi;

/**
 * @description: 输入一个整数 n
 *               求1～n这n个整数的十进制表示中1出现的次数。
 * @author: Ling Jian
 * @date: 2020-07-03 16:40
 **/
public class Test_43 {
    public static void main(String[] args) {
        int n=13;
        System.out.println(countDigitOne1(n));

    }

    //超出内存限制
    public static int countDigitOne(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=n ; i++) {
            sb.append(i);
        }
        char[] chs = sb.toString().toCharArray();
        int count=0;
        for (int i = 0; i <chs.length ; i++) {
            if (chs[i] == '1') {
                count++;
            }
        }
        return count;

    }

    public static int countDigitOne1(int n) {
        int count=0;
        for (int i = 1; i <=n ; i++) {
            count += countOne(i);
        }
        return count;
    }

    public static int countOne(int n){
        int count=0;
        while(n!=0){
            if(n%10==1){
                count++;
            }
            n/=10;
        }
        System.out.println("-------"+count);
        return count;
    }


}
