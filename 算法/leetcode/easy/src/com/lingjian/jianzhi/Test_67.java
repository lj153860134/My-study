package com.lingjian.jianzhi;

/**
 * @description: 写一个函数 StrToInt
 * 实现把字符串转换成整数这个功能
 * 不能使用 atoi 或者其他类似的库函数。
 * @author: Ling Jian
 * @date: 2020-06-30 17:18
 **/
public class Test_67 {
    public static void main(String[] args) {
        String s = "3.4";
        int res = strToInt(s);
        System.out.println(res);
    }

    public static int strToInt(String str) {
        char[] chs = str.trim().toCharArray();
        int a=Integer.MAX_VALUE/10;
        int i=1;
        int sigh=1;
        int res=0;
        if(chs[0]=='-'){
            sigh=-1;
        }else if(chs[0]!='+'){
            i=0;
        }
        for (int j = i; j <chs.length ; j++) {
            if(chs[j]>'9'||chs[j]<'0') break;
            if(res>a||(res==a&&chs[j]>'7'))
                return sigh == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        res=res*10+(chs[j]-'0');
        }
        return sigh * res;
    }

}
