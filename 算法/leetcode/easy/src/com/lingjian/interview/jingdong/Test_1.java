package com.lingjian.interview.jingdong;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class Test_1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int start = sc.nextInt();
//        int end = sc.nextInt();
//        int res = solution(start, end);
        int res = solution(1,10000 );
        System.out.println(res);
//        System.out.println(judge(1007));

    }

    public static int solution(int start, int end){
        int count=0;
        for (int i = start; i <=end ; i++) {
            if(judge(i)){
                count++;
//                System.out.println(i+"===="+count);
            }
        }
        return count;
    }
    public static boolean judge(int num){
        String s = String.valueOf(num);
        String str = s;
        for (int i = 0; i <s.length() ; i++) {
            if(s.length()>1) {
                str = s.substring(0, i) + s.substring(i + 1, s.length());

            }
            if(s.length()==1){
                return false;
            }
            if(su(str)&&hui(str)) return true;
        }
        return false;
    }


    //判断回文
    public static boolean hui(String s ){
        char[] chs = s.toCharArray();
        int left=0;
        while(left<chs.length&&chs[left]=='0'){
            left++;
        }
        int right = chs.length - 1;
        while(left<right){

            if(chs[left]!=chs[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //判断素数
    public static boolean su(String s){
        int num = Integer.parseInt(s);
        if(num<=1){
            return false;
        }
        if(num==2){
            return true;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <=sqrt ; i++) {
            if(num%i==0) return false;
        }
        return true;
    }
    
}
