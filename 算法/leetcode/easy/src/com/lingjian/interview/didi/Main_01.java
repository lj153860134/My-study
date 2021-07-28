package com.lingjian.interview.didi;

import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-13 19:38
 **/
public class Main_01 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = Integer.parseInt(sc.nextLine());
            String s = sc.nextLine();
            //n 是长度
            StringBuilder res = new StringBuilder();
            int index = 0;
            while (index<s.length()) {
                StringBuilder tmp = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (index>= s.length()) {
                        break;
                    }
                    tmp.append(s.charAt(index++));
                }
                StringBuilder reverse = tmp.reverse();
                res.append(reverse);
            }
            System.out.println(res.toString());
        }

    }
