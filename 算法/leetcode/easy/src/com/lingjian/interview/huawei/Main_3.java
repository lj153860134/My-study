package com.lingjian.interview.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-02 19:31
 **/
public class Main_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] size = new int[m];
        int[] value=new int[m];
        for (int i = 0; i <m ; i++) {
            size[i] = sc.nextInt();
        }
//        System.out.println(Arrays.toString(size));
        for (int i = 0; i <m ; i++) {
            value[i] = sc.nextInt();
        }
//        System.out.println(Arrays.toString(value));
        int res = maxValue1(size, value, n);
        System.out.println(res);
    }

    public static int maxValue(int[] size, int[] value, int aim) {
        int[][] dp = new int[size.length + 1][aim + 1];
        for (int i = 1; i < size.length + 1; i++) {
            for (int j = 1; j < aim + 1; j++) {
                if (j - size[i-1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - size[i-1]] + value[i-1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
        return dp[size.length][aim];
    }


        public static int maxValue1 (int[] w, int[] v, int C) {
            int size = w.length;
            if (size == 0) {
                return 0;
            }

            int[] dp = new int[C + 1];
            for (int i = 0; i <= C; i++) {
                dp[i] = w[0] <= i ? v[0] : 0;
            }

            for (int i = 1; i < size; i++) {
                for (int j = C; j >= w[i]; j--) {
                    dp[j] = Math.max(dp[j], v[i] + dp[j - w[i]]);
                }
            }
            return dp[C];
        }
    }



