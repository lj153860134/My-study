package com.lingjian.leetcode;

/**
 * @description: 判断一个 9x9 的数独是否有效
 *               只需要根据以下规则
 *               验证已经填入的数字是否有效即可。
 * @author: Ling Jian
 * @date: 2020-08-10 17:49
 **/
public class Test_36 {
    public static void main(String[] args) {

    }

    public static boolean isValidSudoku(char[][] board) {
        return judgeByRow(board)&&judgeByCol(board)&&judgeByBlock(board);
    }

    public static boolean judgeByRow(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] num = new int[10];
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int temp = board[i][j] - '0';
                    if (num[temp] == 1) {
                        return false;
                    } else {
                        num[temp]++;
                    }

                }
            }
        }
        return true;
    }


    public static boolean judgeByCol(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            int[] num = new int[10];
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.') {
                    int temp = board[j][i] - '0';
                    if (num[temp] == 1) {
                        return false;
                    } else {
                        num[temp]++;
                    }

                }
            }
        }
        return true;

    }

    public static boolean judgeByBlock(char[][] board) {
        for (int i = 0; i <board.length ; i+=3) {

            for (int j = 0; j <board[0].length ; j+=3) {
                int[] num = new int[10];
                for (int k = 0; k <3 ; k++) {
                    for (int l = 0; l <3 ; l++) {
                        if(board[i+k][j+l]!='.'){
                            int temp = board[i+k][j+l] - '0';
                            if (num[temp] == 1) {
                                return false;
                            } else {
                                num[temp]++;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }





}


