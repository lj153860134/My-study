package com.lingjian.interview.vivo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-12 23:15
 **/
public class Main_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] strs = s.split(",");
        int[] num = new int[strs.length];
        int index = 0;
        for (String str : strs) {
            num[index++] = Integer.parseInt(str);
        }
        int[] inDegree = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            if (num[i] != -1) {
                inDegree[i]++;
            }
        }
//        System.out.println(Arrays.toString(inDegree));
        LinkedList<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append('"');
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Collections.sort(queue);
            for (int i = queue.size(); i > 0; i--) {
                int temp = queue.pollFirst();
                sb.append(temp + ",");
                for (int j = 0; j < num.length; j++) {
                    if (num[j] == temp) {
                        inDegree[j]--;
                        if (inDegree[j] == 0) {
                            queue.add(j);
                        }
                    }


                }
            }

        }
        sb.deleteCharAt(sb.length() - 1).append('"');
        System.out.println(sb.toString());


    }
}
