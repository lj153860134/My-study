package com.lingjian.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给定一个二维网格board和一个字典中的单词列表words
 *               找出所有同时在二维网格和字典中出现的单词
 *               单词必须按照字母顺序
 *               通过相邻的单元格内的字母构成
 *               其中“相邻”单元格是那些水平相邻或垂直相邻的单元格
 *               同一个单元格内的字母在一个单词中不允许被重复使用
 * @author: Ling Jian
 * @date: 2020-08-24 22:24
 **/
public class Test_212 {
    public static void main(String[] args) {
        String[] words = new String[]{"a"};
        char[][] board=new char[][]{{'o','a','a','n'},
                                    {'e','t','a','e'},
                                    {'i','h','k','r'},
                                    {'i','f','l','v'}};
        List<String> res = findWords(board, words);
        System.out.println(Arrays.toString(res.toArray()));

    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        for (String s : words) {
            for (int i = 0; i <m ; i++) {
                for (int j = 0; j <n ; j++) {
                    if(dfs(board,i,j,s,0)){
                        if(!res.contains(s)){
                    res.add(s);
                        }
                    }
                }
            }
        }
        return res;
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
