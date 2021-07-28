package com.lingjian.interview.zhongxin;

import java.util.Scanner;

/**
 * @description:  中兴第一题
 * @author: Ling Jian
 * @date: 2020-08-31 10:30
 **/
public class Test_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i <n ; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i <n ; i++) {
            b[i] = sc.nextInt();
        }
        int res = solution(a, b);

        System.out.println(res);

    }

    public static int solution(int[] a, int[] b) {
        int n = a.length;
        int p1 = 0;
        int p2 = 0;
        int res = 0;
        while (p1 < a.length && p2 < b.length) {
            if (a[p1] >b[p2]) {
                res += n - p1 ;
                p2++;
            }else{
                p1++;
            }

        }
        return res;
    }
}
