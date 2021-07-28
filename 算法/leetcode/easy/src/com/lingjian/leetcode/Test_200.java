package com.lingjian.leetcode;

import sun.applet.Main;

/**
 * @description: 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格
 *               请你计算网格中岛屿的数量
 *               岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *               此外，你可以假设该网格的四条边均被水包围
 * @author: Ling Jian
 * @date: 2020-06-13 16:54
 **/
public class Test_200 {
    public static void main(String[] args) {
        char[][] grid={{1,1,1,1,0},
                      {1,1,0,1,0},
                      {1,1,0,0,0},
                      {1,1,0,0,0}};
        int res = numIslands(grid);
        System.out.println(res);
    }

    public static int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int count=0;
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <column ; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    infect(grid,row,column,i,j);
                }
            }
        }
        return count;

    }

    private static void infect(char[][] grid, int row, int column, int i, int j) {
        if (i >= row || j >= column || i < 0 || j < 0 || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2;
        infect(grid,row,column,i+1,j);
        infect(grid,row,column,i-1,j);
        infect(grid,row,column,i,j+1);
        infect(grid,row,column,i,j-1);
    }
}
