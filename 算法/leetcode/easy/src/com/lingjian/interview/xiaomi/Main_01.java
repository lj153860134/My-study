package com.lingjian.interview.xiaomi;

import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-08 17:39
 **/
public class Main_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs=s.split(" ");
        for (int i = 0; i <strs.length ; i++) {
            int res=solution(strs[i]);
            System.out.println(res);
        }
    }

    public static int solution(String s){
        char[] chs = s.toCharArray();
        if(chs.length<8||chs.length>120){
            return 1;
        }
        int upper=0;
        int lower=0;
        int num=0;
        int cha=0;
        for (int i = 0; i <chs.length ; i++) {
            if(chs[i]>='A'&&chs[i]<='Z'){
                upper++;
            }else if(chs[i]>='a'&&chs[i]<='z'){
                lower++;
            }else if(chs[i]>='0'&&chs[i]<='9'){
                num++;
            }else{
                cha++;
            }

        }
        if(upper>0&&lower>0&&num>0&&cha>0){
            return 0;
        }else{
            return 2;
        }

    }
}
