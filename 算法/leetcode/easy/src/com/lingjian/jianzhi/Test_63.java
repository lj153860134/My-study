package com.lingjian.jianzhi;

/**
 * @description: 假设把某股票的价格按照时间先后顺序存储在数组中
 *               请问买卖该股票一次可能获得的最大利润是多少
 * @author: Ling Jian
 * @date: 2020-07-01 16:56
 **/
public class Test_63 {
    public static void main(String[] args) {
        int[] prices=new int[]{7,1,5,3,6,4};
        int res = maxProfit(prices);
        System.out.println(res);
    }

    public static int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1){
            return 0;
        }
        int min = prices[0];
        int res=0;
        for (int i = 0; i <prices.length ; i++) {
            if(prices[i]<=min){
                min=prices[i];
            }else{
                res = Math.max(res, prices[i] - min);
            }
        }
        return res;
    }


}

