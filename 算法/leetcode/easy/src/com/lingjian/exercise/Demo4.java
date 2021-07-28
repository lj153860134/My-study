package com.lingjian.exercise;

import com.sun.jmx.snmp.IPAcl.SnmpAcl;

import java.util.Arrays;

/**
 * @description: 背包问题
 * @author: Ling Jian
 * @date: 2020-08-06 08:48
 **/
public class Demo4 {
    public static void main(String[] args) {
        int[] weight = {3, 2, 4, 7}; //物品的质量
        int[] value = {5, 6, 3, 19};//每个物品对应的价值
        int bag = 11;
        int res = maxValueDp(weight, value, bag);
        System.out.println(res);
         res = maxValueDFS(weight, value, bag);
        System.out.println(res);
    }
    //动态规划
    //dp[i][j]表示的意义是选择第i个物品 目标背包重量为j的最大价值
    public static int maxValueDp(int[] weight, int[] value, int bag) {
        int[][] dp=new int[weight.length+1][bag+1];
        int m = dp.length;
        int n = dp[0].length;
        //base case
        //当没有挑选过物品 价值为0
        for (int i = 0; i <n ; i++) {
            dp[0][i]=0;
        }
        //当目标背包质量为0  价值为0
        for (int i = 0; i <m ; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                //没有选择第i件物品 最大价值不变
                dp[i][j] = dp[i - 1][j];
                if(j-weight[i-1]>=0){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-weight[i-1]]+value[i-1]);
                }
            }


        }
        return dp[m - 1][n - 1];

    }


    //dfs       其实就是暴力递归
//    static int res=0;
    public static int maxValueDFS(int[] weight, int[] value, int bag) {
         return dfs(weight, value, bag, 0);


    }

    private static int dfs(int[] weight, int[] value, int bag, int index) {
        if(index==weight.length){
            return 0;
        }
        int res = dfs(weight, value, bag, index + 1);
        if(bag-weight[index]>=0){
            res = Math.max(res, dfs(weight, value, bag-weight[index],index+1) + value[index]);

        }
        return res;



    }



}
