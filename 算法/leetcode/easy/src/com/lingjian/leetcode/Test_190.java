package com.lingjian.leetcode;

import org.jcp.xml.dsig.internal.dom.DOMCryptoBinary;

import java.util.Arrays;

/**
 * @description: 颠倒给定的 32 位整数的二进制位
 * @author: Ling Jian
 * @date: 2020-06-04 14:32
 **/
public class Test_190 {
    public static void main(String[] args) {
        int n=-3;
        int res = reverseBits(n);
        System.out.println(res);
    }

    public static int reverseBits(int n) {
        int res=0;
        int[] chs = new int[32];
        for (int i = 31; i >=0 ; i--) {
            chs[31-i] = (n >>> i & 1);
        }
//        System.out.println(Arrays.toString(chs));
        for (int i = 0; i <32 ; i++) {
            res |= chs[i] << i;
        }


        return res;
    }

    public int reverseBits2(int n) {
        int res=0;
        for (int i = 0; i <32 ; i++) {
            res |=  ((n>>>(31-i))&1)<< i;
        }


        return res;
    }




}
