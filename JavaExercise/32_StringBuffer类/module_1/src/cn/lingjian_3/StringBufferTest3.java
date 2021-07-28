package cn.lingjian_3;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019-08-30 - 11:13
 */

/*
*  需求：把字符串反转
*    A:用String反转
*    B:用StringBuffer反转
*
*
*
* */


public class StringBufferTest3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter a String");
        String s=sc.nextLine();
        System.out.println(stringReverse(s));
        //用String反转 效率很低
        System.out.println("--------");
        System.out.println(stringReverse2(s));
        //用StringBuffer反转


    }

    public static String stringReverse(String str){
        String result="";
        char[] chs=str.toCharArray();
        for (int i = chs.length-1; i >=0 ; i--) {
            result+=chs[i];
        }
        return result;
    }

    public static String stringReverse2(String str){
//        StringBuffer sb=new StringBuffer(str);
//        sb.reverse();
//        return sb.toString();
        //一步到位 连式编程
        return new StringBuffer(str).reverse().toString();
    }

}
