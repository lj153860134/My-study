package com.lingjian.test;


import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-02 14:30
 **/
public class Test_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chs = s.toCharArray();
        int count=0;
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (char ch : chs) {
            if (ch == '(') {
                flag = true;
                count++;
            }
            if (ch == ')') {
                count--;
            }
            if(count==0){
                flag = false;
            }
            if (!flag&&ch!='('&&ch!=')') {
                sb.append(ch);
            }
        }

        char[] chs1 = sb.toString().toCharArray();
        String s1 = "";
        for (char c : chs1) {
            if(c!='<'){
                s1 += c;
            }else{
                s1 = s1.substring(0, s1.length() - 1);
            }
        }
        System.out.println(s1);
    }

}
