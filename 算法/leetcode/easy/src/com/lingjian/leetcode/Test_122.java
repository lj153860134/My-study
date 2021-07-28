package com.lingjian.leetcode;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @description: 给定一个数组
 *               它的第i 个元素是一支给定股票第 i 天的价格
 *               设计一个算法来计算你所能获取的最大利润
 *               你可以尽可能地完成更多的交易（多次买卖一支股票）
 *               注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @author: Ling Jian
 * @date: 2020-07-31 19:30
 **/
public class Test_122 {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        int res = maxProfit1(nums);
//        System.out.println(res);

    }
    public static int maxProfit(int[] prices) {
        int res=0;
        for(int i=1;i<prices.length;i++){
            int gap=prices[i]-prices[i-1];
            if(gap>0) res+=gap;
        }
        return res;
    }

    //动态规划
    public static int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：持有现金
        // 1：持有股票
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        int[][] dp = new int[len+1][2];

        dp[1][0] = 0;
        dp[1][1] = -prices[0];

        for (int i = 2; i < dp.length; i++) {
            // 这两行调换顺序也是可以的
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i-1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i-1]);
        }

        return dp[len][0];
    }


}
