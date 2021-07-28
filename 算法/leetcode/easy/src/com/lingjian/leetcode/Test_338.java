package com.lingjian.leetcode;

import java.util.Arrays;

/**
 * @description: 给定一个非负整数 num
 *                对于 0 ≤ i ≤ num 范围中的每个数字 i
 *                计算其二进制数中的 1 的数目并将它们作为数组返回。
 * @author: Ling Jian
 * @date: 2020-09-03 16:51
 **/
public class Test_338 {
    public static void main(String[] args) {
        int num = 5;
        int[] res=countBits1(num);
        System.out.println(Arrays.toString(res));
    }

    public static int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0]=0;
        for (int i = 1; i <res.length ; i++) {
            res[i] = getCount(i);
        }
        return res;
    }

    public static int getCount(int i){
        int count=0;
        while(i!=0){
            int temp=i&1;
            if(temp==1){
                count++;
            }
            i = i >> 1;
        }
        return count;
    }


    //更简单的思路
    //若i为偶数 则与i/2的1的位数相同
    //若i为奇数 则与i-1的1的位数增加1
    public static int[] countBits1(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i <res.length ; i++) {
            //偶数
            if((i&1)==0){
                res[i] = res[i >> 1];
            }else{
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }

}
