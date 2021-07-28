package com.lingjian.leetcode;

/**
 * @description: 给定一个整数矩阵
 * 找出最长递增路径的长度
 * 对于每个单元格
 * 你可以往上，下，左，右四个方向移动
 * 你不能在对角线方向上移动或移动到边界外（即不允许环绕）
 * @author: Ling Jian
 * @date: 2020-07-21 16:56
 **/
public class Test_329 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {6, 5, 4}, {7, 8, 9}};
        int res = longestIncreasingPath(matrix);
        System.out.println(res);
    }

    //深度优先+dp
    static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int max = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, process(matrix, i, j, cache));
            }
        }
        return max;

    }

    public static int process(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
                    && matrix[x][y] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], process(matrix, x, y, cache));
            }

        }

        return ++cache[i][j];//这个++很精髓 要将cache的值变化


    }

    //深度优先遍历 +dp 另一种写法（更好理解）
    public static int longestIncreasingPath1(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];
        int max = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, search(matrix, Integer.MIN_VALUE, i, j, dp));
            }
        }
        return max;
    }

    private static int search(int[][] matrix, int curNum, int i, int j, int[][] dp) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || matrix[i][j] <= curNum) return 0;
        if (dp[i][j] != 0) return dp[i][j];


        dp[i][j] = Math.max(dp[i][j], search(matrix, matrix[i][j], i - 1, j, dp));
        dp[i][j] = Math.max(dp[i][j], search(matrix, matrix[i][j], i + 1, j, dp));
        dp[i][j] = Math.max(dp[i][j], search(matrix, matrix[i][j], i, j - 1, dp));
        dp[i][j] = Math.max(dp[i][j], search(matrix, matrix[i][j], i, j + 1, dp));

        return ++dp[i][j];
    }


}
