package com.lingjian.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给定一个仅包含数字2-9的字符串
 *               返回所有它能表示的字母组合
 *               给出数字到字母的映射如下（与电话按键相同）
 *               注意1不对应任何字母。
 * @author: Ling Jian
 * @date: 2020-08-09 16:50
 **/
public class Test_17 {
    public static void main(String[] args) {
        String s = "23";
        List<String> list = letterCombinations(s);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static List<String> letterCombinations(String digits) {
      List<String>list=new ArrayList<>();
        String []s=new String[digits.length()];
        int M=digits.length();
        if(s.length==0){
            return list;
        }
        for(int i=0;i<digits.length();i++){
            switch (digits.charAt(i)){
                case '2':s[i]="abc";break;
                case '3':s[i]="def";break;
                case '4':s[i]="ghi";break;
                case '5':s[i]="jkl";break;
                case '6':s[i]="mno";break;
                case '7':s[i]="pqrs";break;
                case '8':s[i]="tuv";break;
                case '9':s[i]="wxyz";break;
            }
        }
        getAllString(s,0,list,"");
        return list;
    }

    public static void getAllString(String[] str, int index, List<String> list, String temp) {
        if (index == str.length - 1) {
            for (int i = 0; i < str[index].length(); i++) {
                list.add(temp + str[index].charAt(i));
            }
            return;

        }
            for (int i = 0; i < str[index].length(); i++) {
                getAllString(str, index + 1, list, temp + str[index].charAt(i));

        }
    }

}



