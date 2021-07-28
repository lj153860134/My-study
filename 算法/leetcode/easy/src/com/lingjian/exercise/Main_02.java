package com.lingjian.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-20 20:06
 **/
public class Main_02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> peoList = new ArrayList<>();
        List<List<Integer>> staList = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            List<Integer> tmpPair = new ArrayList<>();
            int tmpX = sc.nextInt();
            int tmpY=sc.nextInt();
            tmpPair.add(tmpX);
            tmpPair.add(tmpY);
            peoList.add(tmpPair);
        }
        for (int i = 0; i <m ; i++) {
            List<Integer> tmpPair = new ArrayList<>();
            int tmpX = sc.nextInt();
            int tmpY=sc.nextInt();
            tmpPair.add(tmpX);
            tmpPair.add(tmpY);
            staList.add(tmpPair);
        }

        List<Integer> res = new ArrayList<>();
        Integer resInt = Integer.MAX_VALUE;
        for (int i = 0; i <m ; i++) {
            Integer tmpResInt=0;
            for (int j = 0; j <n ; j++) {
                List<Integer> tmpSta = staList.get(i);
                List<Integer> tmpPeo = peoList.get(j);
                Integer theDis=Math.abs(tmpSta.get(0)-tmpPeo.get(0))+Math.abs(tmpSta.get(1)-tmpPeo.get(1));
                tmpResInt += theDis;
            }
            if(tmpResInt<resInt){
                resInt = tmpResInt;
                res.clear();
                res.add(staList.get(i).get(0));
                res.add(staList.get(i).get(1));
            }
        }
        System.out.print(res.get(0)+" "+res.get(1));


    }
}
