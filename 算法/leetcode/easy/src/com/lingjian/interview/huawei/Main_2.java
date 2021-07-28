package com.lingjian.interview.huawei;


import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-02 19:03
 **/
public class Main_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs=s.split(",");
        int m = Integer.valueOf(strs[0]);
        int n = Integer.valueOf(strs[1]);
        if(m==0||n==0){
            System.out.println(0);

        }
        String[] str = new String[m];
        for (int i = 0; i < m; i++) {
            str[i] = sc.nextLine();
        }
        char[][] chs = new char[m][n];
        for (int i = 0; i < m; i++) {
            char[] chs1 = str[i].toCharArray();
            for (int j = 0; j < n; j++) {
                chs[i][j] = chs1[j];
            }
        }
        int res = solution(chs);
        System.out.println(res);
    }

        public static int solution(char[][] nums){
            int count=0;
            for (int i = 0; i <nums.length ; i++) {
                for (int j = 0; j <nums[0].length ; j++) {
                    if(nums[i][j]=='S'){
                        count++;
                        dfs(nums, i, j);
                }
            }

        }
            return count;

    }

    public static void dfs(char[][] chs,int i,int j){
        if(i<0||i>=chs.length||j<0||j>=chs[0].length||chs[i][j]!='S'){
            return;
        }
        chs[i][j] = '0';
        dfs(chs,i+1,j);
        dfs(chs, i - 1, j);
        dfs(chs, i, j - 1);
        dfs(chs, i, j + 1);
    }
}
