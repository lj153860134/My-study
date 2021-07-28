package com.lingjian.interview.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-09 20:04
 **/
public class Main_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] appearance = new int[m];
        int[] value = new int[m];
        for (int i = 0; i <m ; i++) {
            appearance[i] = sc.nextInt();
        }
        for (int i = 0; i <m ; i++) {
            value[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int[] appearance1 = new int[n];
        int[] value1 = new int[n];
        for (int i = 0; i <n ; i++) {
            appearance1[i] = sc.nextInt();
        }
        for (int i = 0; i <n ; i++) {
            value1[i] = sc.nextInt();
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i <m ; i++) {
            sb1.append(appearance[i]).append(value[i]);
        }
        for (int i = 0; i <n ; i++) {
            sb2.append(appearance1[i]).append(value1[i]);
        }
        int res = solution(sb2.toString(), sb1.toString());
        System.out.println(res/2-1);
    }

    public static int solution(String str1,String str2){
        if(str1==null||str2==null||str2.length()>str1.length()||str2.length()<1){
            return -1;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[] next = getNextArray(str2);
        System.out.println(Arrays.toString(next));
        int p=0;
        int q=0;
        while (p < chs1.length && q < chs2.length) {
            if(chs1[p]==chs2[q]){
                p++;
                q++;
            }else if(q==0){
                p++;
            }else{
                q = next[q];
            }
        }
        return q == chs2.length ? p - q : -1;
    }

    public static int[] getNextArray(String s){
        if(s.length()==1){
            return new int[]{-1};
        }
        char[] chs = s.toCharArray();
        int[] next = new int[chs.length];
        next[0]=-1;
        next[1]=0;
        int index=2;
        int temp=0;
        while(index<chs.length){
            if(chs[index-1]==chs[temp]){
                next[index++]=++temp;
            }else if(temp>0){
                temp = next[temp];
            }else{
                next[index++]=0;
            }
        }
        return next;
    }

}
