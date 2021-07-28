package com.lingjian.interview.tengxun;

import java.util.*;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-06 19:58
 **/
public class Main_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <m ; i++) {
            int num = sc.nextInt();
            set.add(num);
        }
        int n = sc.nextInt();
        for (int i = 0; i <n ; i++) {
            int count = sc.nextInt();
            if (set.contains(count)) {
                list.add(count);
            }
        }
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }
}
