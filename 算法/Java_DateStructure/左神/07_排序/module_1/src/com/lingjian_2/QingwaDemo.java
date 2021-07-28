package com.lingjian_2;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 青蛙跳格子
 * @author: Ling Jian
 * @date: 2019-12-09 10:32
 **/
public class QingwaDemo {
    public static void main(String[] args) {
        System.out.println(f(6));
    }

    public static int f(int n){
        Map<Integer,Integer> map=new HashMap<>();
        if(n==1)
            return 1;
        if(n==2)
            return 2;

        if(map.get(n)!=null){
            return map.get(n);
        }else{
            map.put(n,f(n-1)+f(n-2));
        }
        return f(n-1)+f(n-2);
    }
}
