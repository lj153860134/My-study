package cn.lingjian_8;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019-08-22 - 14:21
 */
/*
*  需求：字符串反转
*
*
* */
public class StringTest2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter a String");
        String s=sc.nextLine();
        char[] chs=s.toCharArray();
        System.out.println(reversalString(chs,chs.length));

    }
    public static String reversalString(char[] chs,int length) {
        String s1="";
        for (int i = 0; i <length ; i++) {
            String s2=String.valueOf(chs[length-1-i]);
            s1=s1.concat(s2);

        }
        return s1;
    }
}
