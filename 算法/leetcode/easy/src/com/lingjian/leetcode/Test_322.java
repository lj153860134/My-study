package com.lingjian.leetcode;

import java.util.Arrays;

/**
 * @description: 给定不同面额的硬币coins和一个总金额amount
 *               编写一个函数来计算可以凑成总金额所需的最少的硬币个数
 *               如果没有任何一种硬币组合能组成总金额，返回 -1。
 * @author: Ling Jian
 * @date: 2020-08-05 23:08
 **/
public class Test_322 {
    public static void main(String[] args) {
        int[] coins = new int[]{186, 419, 83, 408};
        int amount=6249;
        int res = coinChange(coins, amount);
        System.out.println(res);
    }


    public static int coinChange(int[] coins, int amount) {
        if(coins==null){
            return -1;
        }
        int res = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i =1; i <dp.length ; i++) {
            for (int coin : coins) {
                if(i-coin>=0){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    //dfs+剪枝
    static int ans = 0;

    public static int coinChange1(int[] coins, int amount) {
        ans = amount + 1;
        Arrays.sort(coins);
        dfs(coins, coins.length - 1, amount, 0);
        return ans == amount + 1 ? -1 : ans;
    }


    public static void dfs(int[] coins, int index, int amount, int cnt) {
        if (index < 0) {
            return;
        }
        for (int c = amount / coins[index]; c >= 0; c--) {
            int remainingAmount = amount - c * coins[index];
            int coinsUsed = cnt + c;
            if (remainingAmount == 0) {
                ans = Math.min(ans, coinsUsed);
                break;//剪枝1
            }
            if (coinsUsed + 1 >= ans) {
                break; //剪枝2
            }
            dfs(coins, index - 1, remainingAmount, coinsUsed);
        }
    }

    //这个是不可以的 因为钱是要固定的
    public static int coinChange2(int[] coins,int amount){
        int res = 0;
        Arrays.sort(coins);
        for (int i = coins.length-1; i >=0 ; i--) {
            while(amount>=coins[i]){
                amount -= coins[i];
                res++;
            }

        }
        if(amount==0){
            return res;
        }else{
            return -1;
        }

    }
}
