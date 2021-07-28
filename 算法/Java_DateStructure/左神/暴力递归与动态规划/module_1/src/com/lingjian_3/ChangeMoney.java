package com.lingjian_3;

import java.util.HashMap;

/**
 * @description: 换钱问题
 * @author: Ling Jian
 * @date: 2020-03-16 09:00
 **/
public class ChangeMoney {
    public static void main(String[] args) {
        int[] money = new int[]{1, 2, 3, 5, 10};
        int aim=500;
        long start = 0;
        long end = 0;
//        start = System.currentTimeMillis();
        //暴力递归方式
//        System.out.println(process1(money, 0, aim));
//        end = System.currentTimeMillis();
//        System.out.println("cost time : " + (end - start) + "(ms)");

        //记忆化搜索优化暴力递归
//        start = System.currentTimeMillis();
//        System.out.println(process2(money, 0, aim));
//        end = System.currentTimeMillis();
//        System.out.println("cost time : " + (end - start) + "(ms)");

        //动态规划
//        start = System.currentTimeMillis();
//        System.out.println(process3(money, aim));
//        end = System.currentTimeMillis();
//        System.out.println("cost time : " + (end - start) + "(ms)");

        //优化动态规划
        start = System.currentTimeMillis();
        System.out.println(process4(money, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

        //最终优化动态规划
        start = System.currentTimeMillis();
        System.out.println(process5(money, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

    }


    /**
     * 暴力递归方式
     *
     * @param money 兑换钱的数组 全局变量
     * @param index
     * @param aim
     * @return
     */
    public static int process1(int[] money, int index, int aim) {

        if (money == null ||money.length==0|| index < 0 || aim < 0) {
            return 0;
        }

        if (index == money.length) {
            return aim == 0 ? 1 : 0;
        }
        int res = 0;
        for (int i = 0; money[index] * i <= aim; i++) {
            res += process1(money, index + 1, aim - money[index] * i);
        }
        return res;

    }

    //用map存储计算过的值
    public static HashMap<String, Integer> map = new HashMap<>();

    /**
     * 用map记录计算过的值 对暴力递归进行优化
     * 记忆化搜索 慢慢向动态规划靠近
     *
     * @param money
     * @param index
     * @param aim
     * @return
     */
    public static int process2(int[] money, int index, int aim) {
        if (money == null ||money.length==0|| index < 0 || aim < 0) {
            return 0;
        }

        if (index == money.length) {
            return aim == 0 ? 1 : 0;
        }
        int res = 0;
        for (int i = 0; money[index] * i <= aim; i++) {
            int nextAim = aim - money[index] * i;
            String key = String.valueOf(index + 1) + "_" + String.valueOf(nextAim);
            if (map.containsKey(key)) {
                res += map.get(key);
            } else {
                res += process2(money, index + 1, nextAim);
                map.put(String.valueOf(index) + "_" + String.valueOf(aim), res);
            }
        }
        return res;

    }


    /**
     * 动态规划
     * @param money
     * @param aim
     * @return
     */
    public static int process3(int[] money, int aim) {
        if (money == null||money.length==0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[money.length + 1][aim + 1];
        dp[money.length][0] = 1;
        for (int i = money.length - 1; i >= 0; i--) {
            for (int j = 0; j <= aim; j++) {
                for (int k = 0; j - money[i] * k >= 0; k++) {
                    dp[i][j] += dp[i + 1][j - money[i] * k];
                }
            }
        }
        return dp[0][aim];

    }

    /**
     * 优化动态规划
     * @param money
     * @param aim
     * @return
     */
    public static int process4(int[] money, int aim) {
        if (money == null ||money.length==0|| aim < 0) {
            return 0;
        }
        int[][] dp = new int[money.length + 1][aim + 1];
        dp[money.length][0] = 1;
        for (int i = money.length - 1; i >= 0; i--) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j]=dp[i+1][j];
                dp[i][j]+=j-money[i]>=0?dp[i][j-money[i]]:0;
            }
        }
        return dp[0][aim];
    }


    /**
     * 最终优化动态规划
     * @param money
     * @param aim
     * @return
     */
    public static int process5(int[] money, int aim) {
        if (money == null || money.length == 0 || aim < 0) {
            return 0;
        }
        int[] dp = new int[aim + 1];
        for (int j = 0; money[0] * j <= aim; j++) {
            dp[money[0] * j] = 1;
        }
        for (int i = 1; i < money.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[j] += j - money[i] >= 0 ? dp[j - money[i]] : 0;
            }
        }
        return dp[aim];
    }
}

