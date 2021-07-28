package com.lingjian.interview.wangyi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-12 14:59
 **/
public class Main_04 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int m = sc.nextInt();
            int n = sc.nextInt();
            HashMap<Integer, List<Integer>> tree = new HashMap<>();
            for(int i = 0; i < n; i++){
                int root = sc.nextInt();
                String s = sc.next();
                int child = sc.nextInt();
                List<Integer> list = new ArrayList<>();
                if(tree.containsKey(root)){
                    list = tree.get(root);
                }
                list.add(child);
                tree.put(root, list);
            }
            int res = 0;
            for(int i = 1; i <= m; i++){
                List<Integer> list = tree.get(i);
                if(list == null) continue;
                if(list.size() != 2){
                    continue;
                }
                boolean flag = true;
                for(int j : list){
                    if(tree.containsKey(j)) flag = false;
                }
                if(flag ) {
                    res++;
                }
            }
            System.out.println(res);
        }

    }
