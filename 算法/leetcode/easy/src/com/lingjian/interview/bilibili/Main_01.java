package com.lingjian.interview.bilibili;


import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-04 18:59
 **/
public class Main_01 {
    public static void main(String[] args) {
        String str = "aaabbaaac";
        int res = GetFragment(str);
        System.out.println(res);
    }
    public static int GetFragment (String str) {
        char[] chs = str.toCharArray();
        if(chs.length==0){
            return 0;
        }
        if(chs.length==1){
            return 1;
        }
        char temp=chs[0];
        int res=0;
        int cnt=0;
        int count=1;
        for (int i = 0; i <chs.length ; i++) {
           if(chs[i]==temp){
               cnt++;
           }else{
               count++;
               res += cnt;
               cnt=1;
               temp = chs[i];
           }

        }
        res += cnt;
        return (int)(res/count);
    }
}
