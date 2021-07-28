package com.lingjian.interview.baidu;




import java.util.HashMap;
import java.util.Scanner;

public class Main_1 {
    static int res;
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aim = sc.nextInt();
        int step = sc.nextInt();

        getMax(step, aim, 0, 0,aim);

        System.out.println(res);
    }

    public static void getMax(int step, int aim, int m, int n,int aim2) {
        if (aim == 0) {
            res++;
            res %= 1000000007;
            map.put(aim2, res);
            return;
        }
        
        for (int i = 1; i <=step; i++) {
            if (i == m || i == n) {
                continue;
            }

                if (aim >= i) {
                    getMax(step, aim - i, n, i, aim);
                }
            }
        }
    }



