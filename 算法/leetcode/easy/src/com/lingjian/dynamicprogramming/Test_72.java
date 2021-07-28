package com.lingjian.dynamicprogramming;

/**
 * @description: 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数
 *               你可以对一个单词进行如下三种操作：
 *               插入一个字符
 *               删除一个字符
 *               替换一个字符
 * @author: Ling Jian
 * @date: 2020-06-03 15:29
 **/
public class Test_72 {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        int res = minDistance(word1, word2);
        System.out.println(res);

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
