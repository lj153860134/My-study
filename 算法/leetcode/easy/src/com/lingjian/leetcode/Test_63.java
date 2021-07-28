package com.lingjian.leetcode;

/**
 * @description:  一个机器人位于一个m x n网格的左上角
 *               （起始点在下图中标记为“Start” ）
 *                机器人每次只能向下或者向右移动一步
 *                机器人试图达到网格的右下角
 *                （在下图中标记为“Finish”）。
 *                现在考虑网格中有障碍物
 *                那么从左上角到右下角将会有多少条不同的路径？
 * @author: Ling Jian
 * @date: 2020-07-06 14:59
 **/
public class Test_63 {
    public static void main(String[] args) {

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        int m=dp.length;
        int n=dp[0].length;
        for(int i=0;i<m;i++) {
            if(obstacleGrid[i][0]==1) break;
            dp[i][0]=1;
        }
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]==1) break;
            dp[0][i]=1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    continue;
                }
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];


    }
}
