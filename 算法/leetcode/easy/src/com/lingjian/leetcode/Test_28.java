package com.lingjian.leetcode;

/**
 * @description: 给定一个haystack 字符串和一个 needle 字符串，
 *               在 haystack字符串中找出 needle 字符串出现的第一个位置 (从0开始)
 *               如果不存在，则返回-1
 *               KMP算法
 * @author: Ling Jian
 * @date: 2020-06-13 18:39
 **/
public class Test_28 {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "llo";
        int res = strStr(str1, str2);
        System.out.println(res);
        res = getIndex(str1, str2);
        System.out.println(res);
    }

    public static int strStr(String haystack, String needle) {
        if(needle ==null){
            return 0;
        }
        if(haystack ==null|| needle.length()> haystack.length()){
            return -1;
        }
        int[] next = getIndexArray(needle);
        int p1=0;
        int p2=0;
        char[] chs1 = haystack.toCharArray();
        char[] chs2 = needle.toCharArray();
        while (p1 < chs1.length && p2 < chs2.length) {
            if (chs1[p1] == chs2[p2]) {
                p1++;
                p2++;
            } else if (p2 == 0) {
                p1++;
            }else{
                p2 = next[p2];
            }
        }
        return p2 == chs2.length ? p1 - p2 : -1;
    }

    public static int[] getIndexArray(String str) {
        if(str.length()==1){
            return new int[]{-1};
        }
        char[] chs = str.toCharArray();
        int[] next = new int[chs.length];
        next[0]=-1;
        next[1]=0;
        int cn=0;
        int i = 2;
        while (i < next.length) {
            if (chs[i - 1] == chs[cn]) {
                next[i++]=++cn;
            }else if(cn>0){
                cn = next[cn];
            }else{
                next[i++]=0;
            }
        }
        return next;
    }

    //练习KMP算法
    public static int getIndex(String s1, String s2) {
        if(s2==null||s2.length()==0){
            return 0;
        }
        if(s1==null||s1.length()<s2.length()){
            return -1;
        }
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int[] next = getNextArray(s2);
        int p=0;
        int q=0;
        while(p<chs1.length&&q<chs2.length){
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
        int index = 2;
        int temp=0;
        while(index<next.length){
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

}
