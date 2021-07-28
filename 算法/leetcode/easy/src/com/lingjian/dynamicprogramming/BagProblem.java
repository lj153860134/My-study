package com.lingjian.dynamicprogramming;

import java.util.ArrayList;

import java.util.List;


/**
 * @description: 背包问题 （暴力递归   动态规划）
 * @author: Ling Jian
 * @date: 2020-06-04 16:28
 **/
public class BagProblem {
    public static void main(String[] args) {
        int[] weight = {3, 2, 4, 7 }; //物品的质量
        int[] value = {5, 6, 3,6 };//每个物品对应的价值
        int bag = 10;
        System.out.println(maxValueRecur(weight, value, bag));
//        System.out.println(maxValueDP(weight, value, bag));
        maxValueDP1(weight, value, bag);
    }


    //暴力递归
    public static int maxValueRecur(int[] weight, int[] value, int bag) {
        return process(weight,  value,0, bag);
    }

    private static int process(int[] weight, int[] value, int start, int aim) {
        if (start==weight.length) {
            return 0;
        }
        if(aim-weight[start]>=0) {
            return Math.max(process(weight, value, start + 1, aim), process(weight, value, start + 1, aim - weight[start]) + value[start]);
        }
        return process(weight,value,start+1,aim);
    }

    //动态规划
    //dp[i][j]表示从前i个物品 目标为j重量的最大价值
    //目标dp[weight.length][bag]
    public static int maxValueDP(int[] weight, int[] value, int bag) {
        int[][] dp = new int[weight.length + 1][bag + 1];
        for (int i = 1; i < weight.length + 1; i++) {
            for (int j = 1; j < bag + 1; j++) {
                if (j - weight[i-1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i-1]] + value[i-1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
        return dp[weight.length][bag];
    }


    //动态规划求具体的方案
    public static void maxValueDP1(int[] weight, int[] value, int bag) {
        data[][] dp = new data[weight.length + 1][bag + 1];
        for (int i = 0; i < weight.length + 1; i++) {
            for (int j = 0; j < bag + 1; j++) {
                dp[i][j] = new data(0);
            }
        }
        for (int i = 1; i < weight.length + 1; i++) {
            for (int j = 1; j < bag + 1; j++) {
                if (j - weight[i-1] >= 0) {
                    if(dp[i-1][j].value<dp[i - 1][j - weight[i-1]].value+ value[i-1]){
                        dp[i][j].value = dp[i - 1][j].value+value[i-1];
                        dp[i][j].list=new ArrayList<>(dp[i - 1][j].list);
                        dp[i][j].list.add(value[i - 1]);
                    }else{
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

        }
        for (Integer integer : dp[weight.length][bag].list) {
            System.out.print(integer);
            System.out.println();
        }
        System.out.println(dp[weight.length][bag].value);

    }



    static class data{
        public  int value;
        public List<Integer> list ;

        public data(int value) {
            this.value = value;
            list = new ArrayList<>();
        }
    }

}
