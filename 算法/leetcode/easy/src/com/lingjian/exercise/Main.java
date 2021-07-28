package com.lingjian.exercise;
import java.util.*;
/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-20 19:24
 **/

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
//        if(s.length()==1){
//            System.out.println(s);
//            return;
//        }
        int len=s.length();
        for(int i=1;i<=len/2+1;i++){
            if(i==1&&s.charAt(0)!=s.charAt(1)){
                continue;
            }
            if(i==len/2+1){
                System.out.println(s);
                return;
            }
            if(len%i!=0){
                continue;
            }

            String str=s.substring(0,i);
            int num=len/i;
            StringBuilder sb=new StringBuilder();
            for(int j=1;j<=num;j++){
                sb.append(str);
            }
            if(sb.toString().equals(s)){
                System.out.println(str);
                return;
            }
        }

    }
}