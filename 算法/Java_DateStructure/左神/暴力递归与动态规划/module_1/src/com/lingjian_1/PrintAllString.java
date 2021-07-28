package com.lingjian_1;

/**
 * @description: 打印字符串所有子序列
 * @author: Ling Jian
 * @date: 2019-12-23 20:01
 **/
public class PrintAllString {
    public static void main(String[] args) {
        String s = "abc";
        char[] strs=s.toCharArray();
        printAllSubsequence(strs,0,"");

    }

    public static void printAllSubsequence(char[] strs,int i,String res) {
        if(i==strs.length){
            System.out.println(res);
            return;
        }
            printAllSubsequence(strs, i + 1, res + "");
            printAllSubsequence(strs, i + 1, res + strs[i]);


    }
}

