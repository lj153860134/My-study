package com.lingjian.leetcode;

import java.util.Arrays;

/**
 * @description: 给定一个字符串 s
 *               你可以通过在字符串前面添加字符将其转换为回文串
 *               找到并返回可以用这种方式转换的最短回文串
 * @author: Ling Jian
 * @date: 2020-08-24 16:43
 **/
public class Test_214 {
    public static void main(String[] args) {
        String s = "aacecaaa";
        String res = shortestPalindrome(s);
        System.out.println(res);
    }

    public static String shortestPalindrome(String s) {
        int res = maxLcpLength(new StringBuilder(s).reverse().toString());
//        System.out.println(res);
        StringBuilder sb = new StringBuilder();
        for (int i =1; i <=res ; i++) {
            sb.append(s.charAt(s.length()-i));
        }
        sb.append(s);
        return sb.toString();
    }

    public static int maxLcpLength(String str){
        if(str==null||str.length()==0){
            return 0;
        }
        char[] chs = manacherString(str);
//        System.out.println(Arrays.toString(chs));
        int[] pArr=new int[chs.length];
        int C=-1;
        int R=-1;
        for (int i = 0; i <chs.length ; i++) {
            pArr[i]=R>i?Math.min(pArr[(2*C-i)],R-i):1;
            while(i+pArr[i]<chs.length&&i-pArr[i]>=0){
                if(chs[i-pArr[i]]==chs[i+pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if(i+pArr[i]>R){
                R = i + pArr[i];
                C=i;
            }



            if(R==chs.length){

                return str.length() -pArr[C]+1;
            }
        }
        return 0;

    }

    public static char[] manacherString(String str){
        char[] chs = str.toCharArray();
        int index=0;
        char[] res=new char[chs.length*2+1];
        for (int i = 0; i <res.length ; i++) {
            res[i]=(i&1)==0?'#':chs[index++];
        }
        return res;
    }



}
