package com.lingjian.interview.tengxun;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-06 20:09
 **/
public class Main_02 {
    static int count = 0;
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            List<Integer> tmp = new ArrayList<>();
            for (int i1 = 0; i1 < x; i1++) {
                tmp.add(sc.nextInt());
            }
            list.add(tmp);
        }
        dfs(0,list);
        System.out.println(set.size());
    }

    private static void dfs(int target, List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(target) ){
                set.add(target);
                for (Integer integer : list.get(i)) {
                    if (!set.contains(integer)) {
                        dfs(integer, list);
                    }
                }
            }
        }
    }
}