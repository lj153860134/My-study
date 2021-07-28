package com.lingjian.interview.meituan;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-06 09:57
 **/
public class Main_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        sc.nextLine();
        int[] Aarr = new int[A];
        for (int i = 0; i <A ; i++) {
            Aarr[i] = sc.nextInt();
        }
        sc.nextLine();
        int[] BArr=new int[B];
        for (int i = 0; i <B ; i++) {
            BArr[i] = sc.nextInt();
        }
        sc.nextLine();
        HashSet<Integer> set = new HashSet<>();
        for (int i : Aarr) {
            set.add(i);
        }
        int count=0;
        for (int i : BArr) {
            if(set.contains(i)){
                count++;
            }
        }
        System.out.print(A-count+" ");
        System.out.print(B-count+" ");
        System.out.print(count+" ");
    }

}
