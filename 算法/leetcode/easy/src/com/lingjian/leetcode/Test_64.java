package com.lingjian.leetcode;

import java.util.Arrays;

/**
 * @description: 给定一个包含非负整数的 m x n 网格
 *               请找出一条从左上角到右下角的路径
 *               使得路径上的数字总和为最小
 *               说明：每次只能向下或者向右移动一步
 * @author: Ling Jian
 * @date: 2020-07-24 00:11
 **/
public class Test_64 {

    public static void main(String[] args) {
        int[][] grid=new int[][]{{1,2,5},{3,2,1}};

        int res = minPathSum(grid);
        System.out.println(res);
    }
    public static int minPathSum(int[][] grid) {
        if(grid==null||grid[0].length==0){
            return 0;
        }

        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m+1][n+1];
        dp[m][n]=grid[m-1][n-1];
        for(int i=n-1;i>=1;i--){
            dp[m][i]=grid[m-1][i-1]+dp[m][i+1];
        }
        for(int i=m-1;i>=1;i--){
            dp[i][n]=grid[i-1][n-1]+dp[i+1][n];
        }
        for(int i=m-1;i>=1;i--){
            for(int j=n-1;j>=1;j--){
                dp[i][j]=grid[i-1][j-1]+Math.min(dp[i][j+1],dp[i+1][j]);
            }
        }
        for (int i = 0; i <dp.length ; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[1][1];

    }
}
