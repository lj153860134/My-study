package com.lingjian.leetcode;

/**
 * @description: 给你两个单词word1和word2
 *               请你计算出将word1转换成word2所使用的最少操作数
 *               你可以对一个单词进行如下三种操作
 *               插入一个字符
 *               删除一个字符
 *               替换一个字符
 * @author: Ling Jian
 * @date: 2020-07-24 17:05
 **/
public class Test_72 {
    public static void main(String[] args) {

    }

    public static int minDistance(String word1, String word2) {
        char[] chs1 = word1.toCharArray();
        char[] chs2 = word2.toCharArray();
        int[][] dp = new int[chs1.length + 1][chs2.length + 1];
        for (int i = 0; i < chs1.length + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < chs2.length+1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <chs1.length+1; i++) {
            for (int j = 1; j <chs2.length+1; j++) {
                if(chs1[i-1]==chs2[j-1]){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[chs1.length][chs2.length];
    }
}
