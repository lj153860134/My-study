package com.lingjian.interview.vivo;

import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-12 20:24
 **/
public class Main_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i <s.length() ; i++) {
            String str = s.substring(0, i) + s.substring(i + 1, s.length());

            if(judge(str)){
                System.out.println(str);
                return;
            }
        }
        System.out.println("false");
    }

    public static boolean judge(String s){
        StringBuilder sb = new StringBuilder(s);
        String str = sb.toString();
        if(sb.reverse().toString().equals(str)){
            return true;
        }else{
            return false;
        }
    }
}
