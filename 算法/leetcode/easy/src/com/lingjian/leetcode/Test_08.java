package com.lingjian.leetcode;

import sun.jvm.hotspot.runtime.VM;

/**
 * @description: 请你来实现一个 atoi 函数
 *               使其能将字符串转换成整数。（详细见题解）
 * @author: Ling Jian
 * @date: 2020-08-24 23:00
 **/
public class Test_08 {
    public static void main(String[] args) {
        String s = "9223372036854775808";
        int res = myAtoi(s);
        System.out.println(res);

    }

    public static int myAtoi(String str) {
        str = str.trim();
//        System.out.println(str);
        if(str.length()==0){
            return 0;
        }
        int flag=1;
        StringBuilder sb = new StringBuilder();
        char[] chs = str.toCharArray();
        if(chs[0]=='+'||chs[0]=='-'){
            flag = chs[0] == '+' ? 1 : -1;
            for (int i = 1; i <chs.length ; i++) {
                if(chs[i]>='0'&&chs[i]<='9'){
                    sb.append(chs[i]);
                }else{
                    break;
                }
            }
        }else if(chs[0]>='0'||chs[0]<=9) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] >= '0' && chs[i] <= '9') {
                    sb.append(chs[i]);
                } else {
                    break;
                }
            }
        }else{
            return 0;
        }
        String s = sb.toString();
        System.out.println(s);
        if(s.startsWith("0")){
            s.substring(1);
        }
        char[] chars = s.toCharArray();
        long res=0;
        for (int i = 0; i<chars.length ; i++) {
            res=10*res+chars[i]-'0';
        }
        System.out.println(res);

        if(flag==1){
        res=res>Integer.MAX_VALUE?Integer.MAX_VALUE:res;}
        else{
            res=res>Integer.MAX_VALUE?Integer.MIN_VALUE:res;
        }
        return (int)res * flag;
    }

}
