package com.lingjian.interview.xiaomi;

import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-08 18:51
 **/
public class Main_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board=new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String s = sc.nextLine();
//        sc.nextLine();
        if(s.length()==0){
            System.out.println("false");
            return;
        }
        boolean res = solution(board, s);
        if(res){
            System.out.println("true");
        }else{
            System.out.println("false");
        }


    }
    public static boolean solution(char[][] board,String s){
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if(dfs(board,i,j,s,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board,int i,int j,String s,int index){
        int m = board.length;
        int n = board[0].length;
        if(index==s.length()){
            return true;

        }
        if(i<0||i>=m||j<0||j>=n||board[i][j]=='*'){
            return false;
        }
        if(board[i][j]!=s.charAt(index)){
            return false;
        }
        char ch = board[i][j];
        board[i][j] = '*';
        boolean flag=dfs(board,i+1,j,s,index+1)||
                dfs(board,i,j+1,s,index+1)||
                dfs(board,i-1,j,s,index+1)||
                dfs(board,i,j-1,s,index+1);
        board[i][j] = ch;
        return flag;
    }
}
