package com.lingjian.interview.vivo;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-12 20:01
 **/
public class Main_01 {
    static int res =0;
    static LinkedList<Character> list = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int startC = sc.nextInt();
        int startR = sc.nextInt();
        int endC = sc.nextInt();
        int endR = sc.nextInt();
        sc.nextLine();
        char[][] chs = new char[m][m];
        for (int i = 0; i <m ; i++) {
            String s = sc.nextLine();
            for (int j = 0; j <m ; j++) {
                chs[i][j]=s.charAt(j);
            }
        }
        list.add(chs[startR][startC]);
        bfs(chs,startR,startC,endR,endC);
        if(res==Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(res);
        }

    }
    public static void bfs(char[][]chs,int i,int j,int m,int n){
        while(!list.isEmpty()){
            char c = list.poll();
            if(i+1<chs.length&&chs[i+1][j]!='#'&&chs[i+1][j]!='@'){
                if(i+1==m&&j==n) return;
                list.addLast(chs[i+1][j]);
            }
            if(i-1>=0&&chs[i-1][j]!='#'&&chs[i-1][j]!='@'){
                if(i-1==m&&j==n) return;
                list.addLast(chs[i-1][j]);
            }
            if(j+1<chs[0].length&&chs[i][j+1]!='#'&&chs[i][j+1]!='@'){
                if(i==m&&j+1==n) return;
                list.addLast(chs[i][j+1]);
            }
            if(j-1>=0&&chs[i][j-1]!='#'&&chs[i][j-1]!='@'){
                if(i==m&&j-1==n) return;
                list.addLast(chs[i][j-1]);
            }

            res++;

        }
    }
}
