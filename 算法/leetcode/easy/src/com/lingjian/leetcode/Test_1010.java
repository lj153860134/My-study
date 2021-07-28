package com.lingjian.leetcode;

/**
 * @description: 总持续时间可被60整除的歌曲
 * @author: Ling Jian
 * @date: 2020-05-26 14:16
 **/
public class Test_1010 {
    public static void main(String[] args) {
        int[] time = new int[]{30,20,150,100,40};
        int res= numPairsDivisibleBy60(time);
        System.out.println(res);
    }

    //第一种方法 暴力方法（会超时）
    public static int numPairsDivisibleBy60(int[] time) {

        int res=0;
        for (int i = 0; i <time.length ; i++) {
            for (int j = i+1; j <time.length ; j++) {
                if((time[i]+time[j])%60==0){
                    res++;
                }
            }
        }
        return res;
    }

    //利用余数 数组hash
    public static int numPairsDivisibleBy60_2(int[] time) {

        int res = 0;
        int[] help = new int[60];
        for (int i = 0; i < time.length; i++) {
            int remainder = time[i] % 60;
            res += help[remainder];
            int target = remainder == 0 ? 0 : 60 - remainder;
            help[target]++;
        }
        return res;
    }

}
