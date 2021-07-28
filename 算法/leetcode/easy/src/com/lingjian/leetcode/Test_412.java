package com.lingjian.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 写一个程序 输出从 1 到 n 数字的字符串表示
 *               1. 如果 n 是3的倍数，输出“Fizz”
 *               2. 如果 n 是5的倍数，输出“Buzz”
 *               3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * @author: Ling Jian
 * @date: 2020-08-24 15:52
 **/
public class Test_412 {
    public static void main(String[] args) {
        List<String> res = fizzBuzz(1);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> res=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%15==0) res.add("FizzBuzz");
            else if(i%3==0) res.add("Fizz");
            else if(i%5==0) res.add("Buzz");
            else res.add(String.valueOf(i));
        }
        return res;
    }
}
