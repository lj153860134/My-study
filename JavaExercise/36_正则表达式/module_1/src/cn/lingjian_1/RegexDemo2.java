package cn.lingjian_1;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019-09-05 - 10:28
 */
/*
*  用正则表达式判断手机号码是否满足要求
* */
public class RegexDemo2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter a telephone number");
        String s=sc.nextLine();
        if(checkTelephone(s))
            System.out.println("true");
        else
            System.out.println("false");
    }

    public static boolean checkTelephone(String s) {
        return s.matches("[1][38]\\d{9}");
    }
}
