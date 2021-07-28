package com.lingjian.jianzhi;

/**
 * @description: 请设计一个函数
 * 用来判断在一个矩阵中是否
 * 存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始
 * 每一步可以在矩阵中向左、右、上、下移动一格
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子
 * @author: Ling Jian
 * @date: 2020-06-21 18:43
 **/
public class Test_12 {
    public static void main(String[] args) {
//        char[][] board = new char[][]{
//                {'a', 'b', 'c', 'e'},
//                {'s', 'f', 'c', 's'},
//                {'a', 'd', 'e', 'e'}
//        };
        char[][] board = new char[][]{
                {'c', 'a', 'a'},
                {'a', 'a', 'a'},
                {'b', 'c', 'd'}
        };
        String n = "aab";
        System.out.println(exist(board, n));

    }

    public static boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        char[] chs = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (process(board, chs, 0, i, j)) {
                    return true;
                }
            }


        }
        return false;
    }

    public static boolean process(char[][] board, char[] chs, int length, int row, int col) {
        if (length == chs.length) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col] != chs[length]) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '0';
        boolean res= process(board, chs, length + 1, row - 1, col) ||
                process(board, chs, length + 1, row + 1, col) ||
                process(board, chs, length + 1, row, col + 1) ||
                process(board, chs, length + 1, row, col - 1);
        board[row][col]=temp;
        return res;


    }
}
