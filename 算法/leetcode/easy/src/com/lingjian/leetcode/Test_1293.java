package com.lingjian.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:  给你一个 m * n 的网格，
 * 其中每个单元格不是 0（空）就是 1（障碍物）
 * 每一步，您都可以在空白单元格中上、下、左、右移动。
 *如果您 最多 可以消除 k 个障碍物，
 * 请找出从左上角 (0, 0) 到右下角 (m-1, n-1) 的最短路径
 * 并返回通过该路径所需的步数。如果找不到这样的路径，则返回 -1。
 *

 * @author: Ling Jian
 * @date: 2020-09-16 10:08
 **/
public class Test_1293 {
    public static void main(String[] args) {

    }


    //DFS 会超时
    public static int shortestPath(int[][] grid, int k) {
        int len = grid.length,col = grid[0].length;
        if (k >= len + col -3) return len+col-2;     //没有这句，超时
        boolean[][] visited = new boolean[len][col];  //避免dfs发生原路返回的情况
        int result = shortestPathDfs(grid,0,0,len,col,0,k,visited);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static int shortestPathDfs(int[][] grid,int i,int j,int row,int col,int covered,int k,boolean[][] visited) {
        if (i < 0 || i >= row || j < 0 || j >= col) return Integer.MAX_VALUE; //递归出口
        if (i == row-1 && j == col-1) return covered;   //递归出口，结果
        if (visited[i][j]) return Integer.MAX_VALUE; //递归出口

        if (grid[i][j] == 1) {
            if (k > 0) k--;   //k做出牺牲，让1变为0
            else return Integer.MAX_VALUE; //k已经为0了，但是此块为1，则是一条死路
        }


        visited[i][j] = true;  //记录这条路径上这个节点已经访问过

        //取4个方向上可能路径的最小值返回
        int minOf4Dicrect = Integer.MAX_VALUE;
        minOf4Dicrect = Math.min(minOf4Dicrect,shortestPathDfs(grid,i-1,j,row,col,covered+1,k,visited));
        minOf4Dicrect = Math.min(minOf4Dicrect,shortestPathDfs(grid,i+1,j,row,col,covered+1,k,visited));
        minOf4Dicrect = Math.min(minOf4Dicrect,shortestPathDfs(grid,i,j+1,row,col,covered+1,k,visited));
        minOf4Dicrect = Math.min(minOf4Dicrect,shortestPathDfs(grid,i,j-1,row,col,covered+1,k,visited));

        visited[i][j] = false; //回溯
        return minOf4Dicrect;
    }

    //BFS
    public static int shortestPath1(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        // 非法参数处理
        if (validateInputParams(k, m, n)) {
            return -1;
        }
        // 特殊场景处理
        if (m == 1 && n == 1) {
            return 0;
        }

        // BFS对于当前点的下一个点选择，如果grid[i][j]=0则有效入队列 visited[i][j]记录消除障碍次数
        // 若grid[i][j]=1则看是否还有消除障碍机会，若没有 此点丢弃
        // 若有消除障碍机会， （上一个点剩余消除障碍机会 - 1）比visited[i][j] 值比大 此点入队， 小则丢弃（贪心）
        // 例子：k=1, 坐标(0,2)可以为消除(0,1)障碍过来的 visited[0][2] = 0，搜索层级为2
        // 也可能为不消除任何障碍过来的 visited[0][2] = 1，层级为6，更新visited[0][2] = 1并入队
        // 因为到后面还需要消除障碍才能到达目标，先消除障碍走到visited[0][2] = 0的肯定到不了目标...
        // 0 1 0 0 0 1 0 0
        // 0 1 0 1 0 1 0 1
        // 0 0 0 1 0 0 1 0

        // 二维标记数组初始状态为-1，值记录剩余消除障碍的次数，剩余次数越多 越有价值（此处贪心，记录局部最优）
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = -1;
            }
        }
        // 初始步数为0，m=n=1的特殊场景已处理
        int minSteps = 0;

        // 初始位置标记已访问,值记录剩余消除障碍物次数  越多越好
        // 1. 对于其他路径到达此点且剩余消除障碍物次数小于等于当前值 —— 剪枝
        // 2. 对于其他路径到达此点且剩余消除障碍物次数大于当前值 —— 取代并入队
        visited[0][0] = k;
        Queue<Point> queue = new LinkedList<>();
        Point startPoint = new Point(0, 0, 0);
        queue.offer(startPoint);

        // 定义四个方向移动坐标
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        // BFS搜索-队列遍历
        while (!queue.isEmpty()) {
            minSteps++;
            // BFS搜索-遍历相同层级下所有节点
            // 当前队列长度一定要在循环外部定义，循环内部有插入对列操作
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point current = queue.poll();
                int x = current.x;
                int y = current.y;
                int oneCount = current.oneCount;

                // 对当前节点四个方向进行识别处理
                for (int j = 0; j < 4; j++) {
                    int xNew = x + dx[j];
                    int yNew = y + dy[j];
                    // 越界判断
                    if (xNew < 0 || xNew >= m || yNew < 0 || yNew >= n) {
                        continue;
                    }
                    // 搜索到目标节点直接返回结果，按层级就是最短步数
                    if (xNew == m - 1 && yNew == n - 1) {
                        return minSteps;
                    }
                    // 穿越障碍次数已满
                    if (grid[xNew][yNew] == 1 && oneCount >= k) {
                        continue;
                    }
                    int oneCountNew = grid[xNew][yNew] == 1 ? oneCount + 1 : oneCount;
                    // 剪枝 - 节点已被访问过，且当前visited记录的剩余障碍物消除次数 >= 当前搜索节点层级的剩余消除次数
                    if (visited[xNew][yNew] != -1 && visited[xNew][yNew] >= k - oneCountNew) {
                        continue;
                    } else {
                        // 否则，贪心将最优值更新，并将该层级节点入队
                        visited[xNew][yNew] = k - oneCountNew;
                    }
                    queue.offer(new Point(xNew, yNew, oneCountNew));
                }
            }
        }
        // BFS没搜索到目标，返回-1
        return -1;
    }

    private static boolean validateInputParams(int k, int m, int n) {
        return m > 40 || m < 1 || n > 40 || n < 1 || k < 1 || k > m * n;
    }

   static class Point {
        int x;
        int y;
        int oneCount;

        public Point(int x, int y, int oneCount) {
            this.x = x;
            this.y = y;
            this.oneCount = oneCount;
        }
    }
}



