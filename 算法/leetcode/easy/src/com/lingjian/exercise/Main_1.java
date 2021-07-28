package com.lingjian.exercise;

import java.util.Scanner;


public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long m=1000000007;
        long[] res = new long[num];
        sc.nextLine();
        for (int i = 0; i <num ; i++) {
            String s = sc.nextLine();
            String[] strs=s.split(" ");
            long a=Long.parseLong(strs[0]);
            long b=Long.parseLong(strs[1]);
            if(strs[2].equals("+")){
                res[i] = ((a%m) + (b%m))%m;
            }else if(strs[2].equals("-")){
                res[i]=((a%m) - (b%m))%m;
            }else if(strs[2].equals("*")){
                res[i]=((a%m) * (b%m))%m;
            }else{
                long ans=1;
                while(b!=0){
                    if((b&1)!=0){
                        ans=(ans*a)%m;
                    }
                    b=b>>1;
                    a = (a * a) % m;
                }
                res[i] = ans;
            }
        }
        for (long re : res) {
            System.out.println(re);
        }
    }
}
