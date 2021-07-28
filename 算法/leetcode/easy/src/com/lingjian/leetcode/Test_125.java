package com.lingjian.leetcode;


/**
 * @description: 给定一个字符串，验证它是否是回文串
 *               只考虑字母和数字字符，可以忽略字母的大小写
 * @author: Ling Jian
 * @date: 2020-06-19 16:17
 **/
public class Test_125 {
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));

    }

    //从中间判断
    public static boolean isPalindrome(String s) {
        if(s==null||"".equals(s)){
            return true;
        }
        String str = changeString(s.toLowerCase());
        char[] chs = str.toCharArray();
        int left = chs.length / 2;
        int right=left;
        while(left>=0&&right<chs.length){
            if(chs[left--]!=chs[right++]){
                return false;
            }
        }
        return true;


    }

    public static String changeString(String s){
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        sb.append("#");
        for (int i = 0; i <chs.length ; i++) {
            if((chs[i]<='z'&&chs[i]>='a')||(chs[i]<='9'&&chs[i]>='0')){
                sb.append(chs[i]+"#");
            }
        }
        return sb.toString();

    }

    //从两边判断
    public static boolean isPalindrome1(String s){
        if(s==null||"".equals(s)){
            return true;
        }
        String str = changeString1(s.toLowerCase());
        char[] chs = str.toCharArray();
        int left=0;
        int right = chs.length - 1;
        while(left<right){
            if(chs[left++]!=chs[right--]){
                return false;
            }
        }
        return true;
    }


    public static String changeString1(String s){
        String str = s.toLowerCase();
        char[] chs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <chs.length ; i++) {
            if((chs[i]<='z'&&chs[i]>='a')||(chs[i]<='9'&&chs[i]>='0')){
                sb.append(chs[i]);
            }
        }
        return sb.toString();
    }


}
