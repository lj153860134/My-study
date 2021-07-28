package com.lingjian.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-14 20:43
 **/
public class Test_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }

    //动态规划求具体的方案
    public static void maxValueDP1(int[] weight, int[] value, int bag) {
        data[][] dp = new data[weight.length + 1][bag + 1];
        for (int i = 0; i < weight.length + 1; i++) {
            for (int j = 0; j < bag + 1; j++) {
                dp[i][j] = new data(0);
            }
        }
        for (int i = 1; i < weight.length + 1; i++) {
            for (int j = 1; j < bag + 1; j++) {
                if (j - weight[i-1] >= 0) {
                    if(dp[i-1][j].value<dp[i - 1][j - weight[i-1]].value+ value[i-1]){
                        dp[i][j].value = dp[i - 1][j].value+value[i-1];
                        dp[i][j].list=new ArrayList<>(dp[i - 1][j].list);
                        dp[i][j].list.add(value[i - 1]);
                    }else{
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

        }
        for (Integer integer : dp[weight.length][bag].list) {
            System.out.print(integer);
            System.out.println();
        }
        System.out.println(dp[weight.length][bag].value);

    }

    static class data{
        public  int value;
        public List<Integer> list ;

        public data(int value) {
            this.value = value;
            list = new ArrayList<>();
        }
    }
}
