package com.lingjian.interview.meituan;

import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-06 10:09
 **/
public class Main_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chs = s.toCharArray();
        int count1=0;
        int count2=0;
        for (int i = 0; i < chs.length; i++) {
            if(chs[i]>='A'&&chs[i]<='Z'){
                count1++;
            }else{
                count2++;
            }
        }
        int res = Math.abs(count1 - count2) / 2;
        System.out.println(res);
    }
}
