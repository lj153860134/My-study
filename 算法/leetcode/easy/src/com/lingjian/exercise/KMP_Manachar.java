package com.lingjian.exercise;

import java.util.Arrays;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-08-31 21:10
 **/
public class KMP_Manachar {
    public static void main(String[] args) {
        String s1 = "abcabcd";
        String s2 = "abcd";
        String s3 = "abba";
        int res = getIndex(s1, s2);
        System.out.println(res);

        int ans = getMax(s3);
        System.out.println(ans);
    }

    //KMP
    public static int getIndex(String s1,String s2){
        if(s1==null||s2==null||s1.length()<s2.length()){
            return -1;
        }
        int[] next = getNext(s2);
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int p1=0;
        int p2=0;
        while(p1<s1.length()&&p2<s2.length()){
            if(chs1[p1]==chs2[p2]){
                p1++;
                p2++;

            }else if(p2>0){
                p2 = next[p2];

            }else{
                p1++;
            }
        }
        return p2 == s2.length() ? p1 - p2 : -1;
    }

    public static int[] getNext(String s){
        if(s.length()==1){
            return new int[]{-1};
        }
        int[] next = new int[s.length()];
        next[0]=-1;
        next[1] = 0;
        char[] chs = s.toCharArray();
        int index=2;
        int temp=0;
        while(index<s.length()){
            if(chs[index-1]==chs[temp]){
                next[index++] = ++temp;
            }else if(temp>0){
                temp = next[temp];
            }else{
                next[index++] = 0;
            }
        }
        return next;
    }

    public static int getMax(String s){
        if(s==null||s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        char[] chs = getChar(s);
        int C=-1;
        int R=-1;
        int[] pArr = new int[chs.length];
        int res=0;
        for (int i = 0; i <chs.length ; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while(i+pArr[i]<chs.length&&i-pArr[i]>=0){
                if(chs[i+pArr[i]]==chs[i-pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if(i+pArr[i]>R){
                C = i;
                R = i + pArr[i];
            }
            res = Math.max(res, pArr[i]);

        }
        return res / 2;

    }


    public static char[] getChar(String s){
        char[] chs=new char[s.length()*2+1];
        int index=0;
        for (int i = 0; i <chs.length ; i++) {
            chs[i] = (i & 1) == 0 ? '#' : s.charAt(index++);
        }
        return chs;
    }




}
