package com.lingjian.interview.meituan;

import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-06 10:47
 **/
public class Main_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            sc.nextLine();
            int[] nums = new int[n];
            for (int i = 0; i <n ; i++) {
                nums[i] = sc.nextInt();
                if((nums[i]&1)!=1){
                    System.out.println("NO");
                    break;
                }
            }

        }
    }
}
