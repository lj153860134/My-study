package com.lingjian.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict
 *               判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词
 * @author: Ling Jian
 * @date: 2020-06-04 15:42
 **/
public class Test_139 {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(wordBreak1(s,wordDict));

    }


    //暴力递归(超出时间限定）
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return process(s, set, 0);

    }

    public static boolean process(String s, HashSet<String> set, int start) {
        if (start== s.length()) {
            return true;
        }

        for (int end = start+1; end <=s.length() ; end++) {
            if (set.contains(s.substring(start, end)) && process(s, set, end )) {
                return true;
            }

        }
        return false;
    }


    //动态规划
    //dp[i]表示字符串前n个字符可以被字典 wordDict表示
    //目标dp[s.length()]
    public static boolean wordBreak1(String s, List<String> wordDict){
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j <i ; j++) {
                if(dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
