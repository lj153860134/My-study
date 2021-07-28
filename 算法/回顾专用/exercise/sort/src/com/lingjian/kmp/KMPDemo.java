package com.lingjian.kmp;

import javax.print.attribute.Size2DSyntax;
import java.util.Arrays;

/**
 * @description: KMP算法
 *               str1中是否存在子串str2
 * @author: Ling Jian
 * @date: 2020-05-19 15:49
 **/
public class KMPDemo {
    public static void main(String[] args) {
//        String s1 = "abcabcababaccc";
        String s2 = "aaaab";
//        int result = getIndexOf(s1, s2);
//        System.out.println(result);
        int[] res = getIndexArray(s2.toCharArray());
        System.out.println(Arrays.toString(res));
    }

    private static int getIndexOf(String s1, String s2) {
        if (s2.length() > s1.length() || s1 == null || s2 == null) {
            return -1;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getIndexArray(str2);
        System.out.println(Arrays.toString(next));
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (i2 == 0) {
                i1++;
            } else {
                i2 = next[i2];
            }

        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public static int[] getIndexArray(char[] str) {
        if (str.length == 1) {
            return new int[]{-1};
        }

        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i = 2;
        while (i < str.length) {
            if (str[i - 1] == str[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
