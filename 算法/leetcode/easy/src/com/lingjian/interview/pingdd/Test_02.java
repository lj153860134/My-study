package com.lingjian.interview.pingdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-01 19:58
 **/
public class Test_02 {
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        int[][] nums = new int[m][n];
//        for (int i = 0; i <m ; i++) {
//            for (int j = 0; j <n ; j++) {
//                nums[i][j] = sc.nextInt();
//            }
//        }
        int m = 4;
        int n = 4;

        int[][] nums = new int[][]{{1, 0, 1, 1}, {1, 1, 0, 1}, {0, 0, 0, 0}, {1, 1, 1, 1}};
//        int res = 0;
//        int[][] dp = new int[m][n];
        int count = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(nums[i][j]==1){
                    count++;
                    cnt=0;
                    dfs(nums, i, j, count);
                    System.out.println(cnt);

                }

            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }

    public static void dfs(int[][] nums, int i, int j,int count) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length ||nums[i][j]!=1) {
            return;
        }
        nums[i][j] = count;
        cnt++;
        dfs(nums, i + 1, j, count);
        dfs(nums, i - 1, j, count);
        dfs(nums, i , j+1, count);
        dfs(nums, i , j-1, count);



    }
}
