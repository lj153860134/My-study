package com.lingjian.interview.jingdong;
import java.util.*;
import java.lang.*;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-08-07 09:23
 **/
public class Test_2 {






        final static int maxn = 1000000 + 10;
        static boolean[] isp = new boolean[maxn];
        static int[] pow = new int[10];

        static void init(){
            for (int i = 0; i < maxn; i ++){
                isp[i] = true;
            }
            isp[0] = false;
            isp[1] = false;

            for (int i = 2; i < maxn; i ++){
                if (isp[i] == true){
                    for (int j = i+i; j < maxn; j += i){
                        isp[j] = false;
                    }
                }
            }

            pow[0] = 1;
            for (int i = 1; i < 8; i ++){
                pow[i] = pow[i-1] * 10;
            }

        }

        static int solve(int i, int j){
            int ans = 0;
            ans += i % pow[j];
            ans += i / pow[j+1] * pow[j];
            //System.out.println("ans >>> " + ans);
            return ans;
        }

        static boolean isr(String num){
            boolean res = true;
            int length = num.length();
            for (int i = 0; i < length/2; i ++){
                if( num.charAt(i) != num.charAt(length-i-1) ){
                    res = false;
                    break;
                }
            }

            return res;
        }

        public static void main(String[] args) {

            // write your code here
            init();

/*
        for (int i = 0; i < 1000; i ++){
            //if (isp[i] == true){
            if (isr(String.valueOf(i))){
                System.out.println(i);
            }
        }
*/
            int n, m;
//            Scanner sc = new Scanner(System.in);
//            n = sc.nextInt();
//            m = sc.nextInt();

            int ans = 0;
            for (int i = 1; i <= 10000; i ++){

                int length = String.valueOf(i).length();

                for (int j = 0; j < length; j ++){
                    int buf = solve(i, j);
                    if (isp[buf] && isr(String.valueOf(buf))){

                        ans ++;
//                        System.out.println(i+"===="+ans);
                        //System.out.println(">>> " + i);
                        //System.out.println(buf);
                        break;
                    }
                }

            }
            System.out.println("+++++++++");
            System.out.println(ans);
//            sc.close();
        }

    }


