package com.lingjian.leetcode;

/**
 * @description: 给定一个Excel表格中的列名称，
 *                  返回其相应的列序号。
 * @author: Ling Jian
 * @date: 2020-06-19 16:53
 **/
public class Test_171 {
    public static void main(String[] args) {
        String s = "ZY";
        int res = titleToNumber(s);
        System.out.println(res);

    }

    public static int titleToNumber(String s) {
//        String str = new StringBuilder(s).reverse().toString();
        char[] chs = s.toCharArray();
        int res=0;
        int n=1;
        for (int i = 0; i <chs.length ; i++) {
            int x=chs[chs.length-i-1]-'A'+1;
            res+=n*x;
            n*=26;
        }
        return res;
    }
}
