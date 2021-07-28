package com.lingjian.test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-16 21:03
 **/
public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = 3;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <=k ; i++) {
            list.add(i);
        }
        int index = 0;
        while(list.size() > 1){
            index = (index+n-1)%list.size();
            list.remove(index);
        }
        System.out.println(list.get(0));


    }



    }

