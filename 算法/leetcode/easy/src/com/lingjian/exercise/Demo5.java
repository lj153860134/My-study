package com.lingjian.exercise;

/**
 * @description: 换钱问题（完全背包问题）
 * @author: Ling Jian
 * @date: 2020-08-06 10:00
 **/
public class Demo5 {
    public static void main(String[] args) {
        int[] money = new int[]{1, 2, 3, 5, 10};
        int aim=3;
        System.out.println(process4(money, aim));
    }


    //动态规划
    //dp[i][j]选择完第i个零钱后 目标为j元 换钱的总数
    public static int process4(int[] money, int aim) {
        if (money == null || money.length == 0 || aim < 0) {
            return 0;
        }


        int[][] dp = new int[money.length + 1][aim + 1];
        //base case
        //当选择完第0个零钱 目标为0元 换钱总数为1
        dp[0][0] = 1;

        for (int i = 1; i <dp.length; i++) {
            for (int j = 0; j <dp[0].length; j++) {
                dp[i][j] = dp[i -1][j];
                dp[i][j] += j - money[i-1] >= 0 ? dp[i][j - money[i-1]] : 0;
            }
        }
        return dp[money.length][aim];
    }
}
