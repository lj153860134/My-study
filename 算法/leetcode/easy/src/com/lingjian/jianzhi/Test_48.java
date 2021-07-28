package com.lingjian.jianzhi;

import java.util.HashMap;

/**
 * @description: 请从字符串中找出一个最长的不包含重复字符的子字符串
 *               计算该最长子字符串的长度
 * @author: Ling Jian
 * @date: 2020-07-09 17:09
 **/
public class Test_48 {
    public static void main(String[] args) {
        String s = "bbbb";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);

    }

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
        while(end<n){
            if(map.containsKey(s.charAt(end))){
                start=Math.max(map.get(s.charAt(end)),start);
            }
            map.put(s.charAt(end),end+1);
            res = Math.max(end - start + 1, res);
            end++;
        }
        return res;
    }

}
