package com.lingjian.interview.meituan;

import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-06 11:04
 **/
public class Main_3 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            sc.nextLine();
            int temp=0;
            int temp2 = 0;
            for (int i = 0; i < n; i++) {
                int t = sc.nextInt();
                temp ^= t;
            }
//            sc.nextLine();
            int[] record = new int[n + 1];
            for (int i = 1; i <=n ; i++) {
                record[i] = record[i - 1] ^ i;
            }
            for(int i=2;i<=n;i++){
                int unit = (n - i + 1) / i;
                int re = (n - i + 1) % i;
                if((unit%2)==0){
                    if(re>0) {
                        temp ^= record[re - 1];
                    }
                }else{
                    if(re>0) {
                        temp ^= (record[i - 1] ^ record[re - 1]);
                    }else{
                        temp ^= record[i - 1];
                    }
                }
            }
            if(n%2==0){
                for (int i = 1; i <n ; i+=2) {
                    temp2 ^= i;
                }
            }else{
                for (int i = 2; i <n ; i+=2) {
                    temp2 ^= i;
                }
            }
            temp ^= temp2;
            System.out.print(temp);

        }
    }

