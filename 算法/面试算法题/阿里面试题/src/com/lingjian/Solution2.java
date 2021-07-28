package com.lingjian;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-03-20 09:31
 **/
public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int res=function(n);
    }

    public static int function(int n){
        Scanner sc = new Scanner(System.in);
        String[] strs=new String[n];
        for (int i = 0; i <n ; i++) {
            strs[i]=sc.nextLine();
        }
        char[] cs=new char[n];
        HashMap<> map=new HashMap<>();
        for (int i = 0; i <n ; i++) {
            char[] chs=strs[i].toCharArray();
            char c=chs[chs.length-1];
            cs[i]=c;
            map.put(c,i);
        }


    }
}
