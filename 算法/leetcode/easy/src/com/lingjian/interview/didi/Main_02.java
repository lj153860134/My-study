package com.lingjian.interview.didi;

import sun.tools.jstat.Scale;

import java.util.*;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-13 19:58
 **/
public class Main_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<String> res = new ArrayList<>();
        for (int i = 0; i <num ; i++) {
            int n = sc.nextInt(); //小岛个数
            int m = sc.nextInt(); //建造桥数
            int k=sc.nextInt();
            sc.nextLine();
            int[][]grid=new int[n+1][n+1];
            for (int j = 0; j <m ; j++) {
                String s = sc.nextLine();
                String[] strs=s.split(" ");
                int row = Integer.parseInt(strs[0]);
                int column = Integer.parseInt(strs[1]);
                int money = Integer.parseInt(strs[2]);
                grid[row][column] = money;
            }
            String ans = judge(grid, n, m, k);
            res.add(ans);
        }
        for (String s : res) {
            System.out.println(s);
        }
    }

    public static String judge(int[][] grid,int n,int m,int k){
        HashSet<Integer> set = new HashSet<>();
        int count=0;
        for (int i = 1; i <grid.length ; i++) {
            for (int j = 1; j <grid[0].length ; j++) {
                if(grid[i][j]!=0&&grid[i][j]<=k){
                    if(!set.contains(i)){
                        count++;
                        set.add(i);
                    }
                    if(!set.contains(j)){
                        count++;
                        set.add(j);
                    }

                }
            }
        }
        if(count==m&&set.size()==n){
            return "Yes";
        }else{
            return "No";
        }
    }
}
