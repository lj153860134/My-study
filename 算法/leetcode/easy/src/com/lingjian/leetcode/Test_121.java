package com.lingjian.leetcode;

/**
 * @description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。  如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。  注意：你不能在买入股票前卖出股票
 * @author: Ling Jian
 * @date: 2020-08-05 11:32
 **/
public class Test_121 {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        int res = maxProfit(nums);
        System.out.println(res);
        res = maxProfit1(nums);
        System.out.println(res);
    }

    //贪心
    public static int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1){
            return 0;
        }
        int min=prices[0];
        int res=0;
        for(int i=1;i<prices.length;i++){
            if(min>prices[i]){
                min=prices[i];
            }
            res=Math.max(prices[i]-min,res);
        }
        return res;

    }

    //动态规划
    public static int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：持有现金  最大的收益
        // 1：持有股票  最大的收益

        int[][] dp = new int[len+1][2];

        dp[1][0] = 0;
        dp[1][1] = -prices[0];

        for (int i = 2; i < dp.length; i++) {
            // 这两行调换顺序也是可以的

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i-1]);
            //因为这里只能卖一次 所以这里手上持有的现金一直是0元 收益为0
            dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i-1]);
        }

        return dp[len][0];
    }
}
