package com.lingjian.interview.tengxun;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-06 20:28
 **/
public class Main_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int[] res = new int[2];
        res[0] = nums[n / 2 ];
        res[1] = nums[n / 2 - 1];
        int mid = n / 2;
        for (int i = 1; i <=n ; i++) {
            if(i<=mid){
                System.out.println(res[0]);
            }else{
                System.out.println(res[1]);

            }
        }
    }
}
