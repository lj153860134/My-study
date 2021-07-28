package com.lingjian.interview.pingdd;

import java.util.Scanner;


public class Test_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int mid = 0;
        if (n % 2 == 0) {
            mid = n / 2 - 1;
        } else {
            mid = n / 2;
        }
        if (n % 2 != 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j > mid && i + j < n - 1) arr[i][j] = 1;
                    if (j < mid && j > i) arr[i][j] = 2;
                    if (i < mid && j < i) arr[i][j] = 3;
                    if (i > mid && i + j < n - 1) arr[i][j] = 4;
                    if (j < mid && i + j > n - 1) arr[i][j] = 5;
                    if (j > mid && j < i) arr[i][j] = 6;
                    if (i > mid && j > i) arr[i][j] = 7;
                    if (i < mid && i + j > n - 1) arr[i][j] = 8;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j > mid && i + j < n - 1) arr[i][j] = 1;
                    if (j <= mid && j > i) arr[i][j] = 2;
                    if (i <= mid && j < i) arr[i][j] = 3;
                    if (i > mid && i + j < n - 1) arr[i][j] = 4;
                    if (j <= mid && i + j > n - 1) arr[i][j] = 5;
                    if (j >mid && j < i) arr[i][j] = 6;
                    if (i > mid && j > i) arr[i][j] = 7;
                    if (i <= mid && i + j > n - 1) arr[i][j] = 8;
                }

            }
        }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

