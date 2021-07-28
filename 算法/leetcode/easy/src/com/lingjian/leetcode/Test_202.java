package com.lingjian.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @description: 编写一个算法来判断一个数 n 是不是快乐数
 *              「快乐数」定义为：对于一个正整数，
 *              每一次将该数替换为它每个位置上的数字的平方和，
 *              然后重复这个过程直到这个数变为 1，
 *              也可能是 无限循环 但始终变不到 1。
 *              如果 可以变为  1，那么这个数就是快乐数
 * @author: Ling Jian
 * @date: 2020-06-16 15:59
 **/
public class Test_202 {
    public static void main(String[] args) {
        int n=2;
        System.out.println(isHappy(n));

    }

    public static boolean isHappy(int n) {
        if(n==1){
            return true;
        }
        int sum=n;
        HashSet<Integer> set=new HashSet<>();
        while(sum!=1){
            sum = getNums(sum);
            if(!set.contains(sum)){
                set.add(sum);
            }else{
                return false;
            }
        }
        return true;

    }

    public static int getNums(int n){
        int res=0;
        while(n!=0){
            res += (int)Math.pow(n % 10, 2);
            n/=10;
        }
        return res;
    }
}
