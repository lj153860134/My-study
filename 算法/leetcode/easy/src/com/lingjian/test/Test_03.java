package com.lingjian.test;

import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-02 14:58
 **/
public class Test_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        dp[0]=0;
        dp[1] = nums[0];

        int res = 0;
        for (int i = 2; i <n ; i++) {
            for (int j = 0; j <i-1 ; j++) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i - 1]);
            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);

    }
}
