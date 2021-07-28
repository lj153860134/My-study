package com.lingjian.leetcode;

import com.sun.tools.corba.se.idl.constExpr.ShiftLeft;

import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;

/**
 * @description: 无重复字符的最长子串
 * @author: Ling Jian
 * @date: 2020-04-10 21:19
 **/
public class Test_03 {
    public static void main(String[] args) {
        String s = "aaaaa";
        int result = solution2(s);
        System.out.println(result);
        int result1 = solution3(s);
        System.out.println(result1);

    }
    //暴力解
    public  static int solution(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        char[] chs = s.toCharArray();
        int max=0;
        for (int i = 0; i <chs.length-1 ; i++) {
            int count=0;
            String str=String.valueOf(chs[i]);
            for (int j = i; j <chs.length-1 ; j++) {
                String str1=String.valueOf(chs[j+1]);
                if(str.contains(str1)){
                    break;
                }
                str+=str1;
                count++;
            }
            max=Math.max(count,max);
        }

        return max+1;
    }

    //滑动窗口
    public static int solution2(String s){
        if(s==null||s.length()==0){
            return 0;
        }
        int n=s.length();
        int start=0;
        int end=0;
        int res=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(start<n&&end<n){
            if(map.containsKey(s.charAt(end))){
                //可能其他字母相同 已经导致start变大了 所以要进行比较才行
                start=Math.max(map.get(s.charAt(end)),start);
            }
            map.put(s.charAt(end),end+1);
            res = Math.max(end - start + 1, res);
            end++;
        }
        return res;
    }

    //滑动窗口2（模板）
    public static int solution3(String s){
        if(s==null||s.length()==0){
            return 0;
        }
        int n=s.length();
        int start=0;
        int end=0;
        int res=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(end<n){
            char c=s.charAt(end);
            end++;
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.get(c)>1){
                char d = s.charAt(start);
                start++;
                map.put(d, map.get(d) - 1);
            }
            res = Math.max(res, end - start);

        }
        return res;
    }


    //动态规划  dp[i]表示以s的第i个位置结尾的无重复字符的最长子串
    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int res=0;
        char[] chs = s.toCharArray();
        int[] dp=new int[chs.length+1];
        dp[1]=1;
        for (int i = 2; i <dp.length ; i++) {
            for (int j = 1; j <=dp[i-1] ; j++) {
                if(chs[i-1]==chs[i-1-j]){
                    dp[i]=j;
                    break;
                }
            }
            dp[i] = dp[i] == 0 ? dp[i - 1] + 1 : dp[i];
            res=Math.max(res,dp[i]);

        }
        return res;
    }



}
