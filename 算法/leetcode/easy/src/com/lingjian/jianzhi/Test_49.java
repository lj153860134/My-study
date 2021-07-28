package com.lingjian.jianzhi;

/**
 * @description: 把只包含质因子2 3和5的数称作丑数（Ugly Number）
 *               求按从小到大的顺序的第 n 个丑数
 * @author: Ling Jian
 * @date: 2020-07-09 17:52
 **/
public class Test_49 {
    public static void main(String[] args) {

    }

    public static int nthUglyNumber(int n) {

        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];



    }
}
