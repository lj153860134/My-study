package com.lingjian.exercise;

import java.util.Arrays;

/**
 * @description: KMP算法
 * @author: Ling Jian
 * @date: 2020-08-03 22:14
 **/
public class Demo2 {
    public static void main(String[] args) {
        String str1 = "aabcdaa";
        String str2 = "ab";
//        int res = getIndexOf(str1, str2);
        int res = getCount(str1, str2);
        System.out.println(res);

    }

    public static int getIndexOf(String str1, String str2) {
        if(str1==null||str2==null||str2.length()>str1.length()||str2.length()<1){
            return -1;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[] next = getNextArray(str2);
        System.out.println(Arrays.toString(next));
        int p=0;
        int q=0;
        while (p < chs1.length && q < chs2.length) {
            if(chs1[p]==chs2[q]){
                p++;
                q++;
            }else if(q==0){
                p++;
            }else{
                q = next[q];
            }
        }
        return q == chs2.length ? p - q : -1;
    }

    public static int[] getNextArray(String s){
        if(s.length()==1){
            return new int[]{-1};
        }
        char[] chs = s.toCharArray();
        int[] next = new int[chs.length];
        next[0]=-1;
        next[1]=0;
        int index=2;
        int temp=0;
        while(index<chs.length){
            if(chs[index-1]==chs[temp]){
                next[index++]=++temp;
            }else if(temp>0){
                temp = next[temp];
            }else{
                next[index++]=0;
            }
        }
        return next;
    }

    //KMP
    public static int getCount(String s1, String s2) {
        if(s1==null||s2==null||s2.length()==0||s1.length()<s2.length()){
            return 0;
        }
        int res=0;
        int[] next = getNextArray(s2);
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int p=0;
        int q=0;
        while (p < s1.length()) {
            if (chs1[p] == chs2[q]) {
                p++;
                q++;
            } else if (q == 0) {
                p++;
            } else {
                q = next[q];
            }
            if (q == s2.length()) {
                s1 = s1.substring(p);
                chs1 = s1.toCharArray();
                p = 0;
                q = 0;
                res++;
            }

        }


        return res;
    }
}
