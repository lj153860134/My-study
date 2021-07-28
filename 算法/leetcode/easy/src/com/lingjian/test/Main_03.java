package com.lingjian.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-23 19:30
 **/
public class Main_03 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        ArrayList<String> res = findAllHuiWen(s);
        for (String re : res) {
            if(re.length()>1){
                System.out.print(re+" ");
            }
        }
    }
    public static ArrayList<String> findAllHuiWen(String s){
        ArrayList<String> list = new ArrayList<String>();
        if(s==null || s.length()==0) return list;
        if(s.length()==1) {
            return list;
        }
        for(int i=0; i<s.length(); i++){
            getSubList(s,i,i,list);
            getSubList(s,i,i+1,list);
        }
        return list;
    }

    public static void getSubList(String s, int left, int right, ArrayList<String> list){
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            String subString = s.substring(left, right+1);
            if(!list.contains(subString))
                list.add(subString);
            left--;
            right++;
        }
    }
}
