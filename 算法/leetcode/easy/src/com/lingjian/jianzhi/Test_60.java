package com.lingjian.jianzhi;

import java.util.Arrays;

/**
 * @description: 把n个骰子扔在地上
 *               所有骰子朝上一面的点数之和为s
 *               输入n，打印出s的所有可能的值出现的概率
 *               你需要用一个浮点数数组返回答案
 *               其中第i个元素代表这n个骰子所能掷出的点数集合中第i小的那个的概率。
 * @author: Ling Jian
 * @date: 2020-07-04 17:03
 **/
public class Test_60 {
    public static void main(String[] args) {
        int n = 2;
        double[] res = twoSum(n);
        System.out.println(Arrays.toString(res));
    }

    public static double[] twoSum(int n) {
        double pre[]={1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
        for(int i=2;i<=n;i++){
            double tmp[]=new double[5*i+1];
            for(int j=0;j<pre.length;j++)
                for(int x=0;x<6;x++)
                    tmp[j+x]+=pre[j]/6;
            pre=tmp;
        }
        return pre;
    }
}
