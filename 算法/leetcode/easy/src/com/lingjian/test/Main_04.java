package com.lingjian.test;

import java.util.Arrays;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-25 19:11
 **/
public class Main_04 {
    public static void main(String[] args) {
        int n=3;
        int k=1;
        String str1 = "ABC";
        String str2 = "DDD";
        int[] res = solve(n, k, str1, str2);
        System.out.println(Arrays.toString(res));
    }
    public static int[] solve(int n,int k,String str1,String str2){
        int[] res = new int[2];
        int count=0;
        for (int i = 0; i <str1.length() ; i++) {
            if(str1.charAt(i)== str2.charAt(i)){
                count++;
            }
        }
        if(n==k){
            res[0] = count;
            res[1] = count;
            return res;
        }
        int mid = n / 2;
        if(k<=mid){
            if(count<=k){
                res[0]=0;
                res[1] = n - (k-count);
            }else{
                if(n%2==0){
                    res[0] = count - k;
                    res[1] = n - (count - k);
                }else{
                    res[0] = count + k - n;
                    res[1] = n - (count - k);
                }
            }
        }else{
            if(count+k>=n){
                res[0]=count+k-n;
                res[1] = n - Math.abs(count - k);
            }else{
                res[0]=0;
                res[1] = count;
            }
        }

        return res;
    }




}
