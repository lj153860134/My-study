package com.lingjian.leetcode;

/**
 * @description: 在二维网格grid上,有4种类型的方格
 *               1 表示起始方格。且只有一个起始方格。
 *               2 表示结束方格，且只有一个结束方格。
 *               0 表示我们可以走过的空方格。
 *               -1 表示我们无法跨越的障碍。
 *               返回在四个方向（上、下、左、右）上行走
 *               从起始方格到结束方格的不同路径的数目
 *               每一个无障碍方格都要通过一次。
 * @author: Ling Jian
 * @date: 2020-07-06 15:12
 **/
public class Test_980 {
    public static void main(String[] args) {
        int[] [] grid=new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
//        int[] [] grid=new int[][]{{1,0,0},{0,0,0},{2,-1,0}};
        int res = uniquePathsIII(grid);
        System.out.println(res);

    }

    static int count = 0;

    public static int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int step=1;
        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
                if(grid[i][j]==0){
                    step++;
                }

            }
        }
        process(grid, startRow, startCol, step);

        return count;


    }

    public static void process(int[][] grid, int i, int j, int step) {
        if(i<0||i==grid.length||j<0||j==grid[0].length||grid[i][j]==-1){
            return;
        }
        if(grid[i][j]==2){
            if(step==0){
                count++;
            }
            return;

        }
        grid[i][j]=-1;
        process(grid, i + 1, j, step-1);
        process(grid, i - 1, j, step-1);
        process(grid, i, j+1, step-1);
        process(grid, i , j-1, step-1);
        grid[i][j]=0;

    }
}
