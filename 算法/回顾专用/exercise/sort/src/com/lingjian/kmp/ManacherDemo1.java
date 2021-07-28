package com.lingjian.kmp;

import javax.naming.PartialResultException;
import java.util.Arrays;

/**
 * @description: 添加最短字符串为回文字符串
 * @author: Ling Jian
 * @date: 2020-05-19 18:05
 **/
public class ManacherDemo1 {

    public static void main(String[] args) {
        String str = "abcd123321";
        String result = maxLcpsLength(str);
        System.out.println(result);
        System.out.println(str+result);
    }

    private static String maxLcpsLength(String str) {
        if (str == null||str.length()==0) {
            return null;
        }
        char[] chs = manacherString(str);
//        System.out.println(Arrays.toString(chs));
        int[] pArr = new int[chs.length];
        int R=-1;
        int C=-1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < pArr.length; i++) {
            pArr[i]=R>i?Math.min(pArr[2*C-i],R-i):1;
            while(i+pArr[i]<pArr.length&&i-pArr[i]>-1) {
                if (chs[i + pArr[i]] == chs[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            if (R == chs.length) {
                break;
            }

        }
        int num = pArr[C];
        System.out.println(num);
        char[] res = new char[str.length() - num+1];
//        System.out.println(res.length);
        char[] strs = str.toCharArray();
        for (int i = 0; i <res.length ; i++) {
            res[i] = strs[res.length -1- i];
        }
        return String.valueOf(res);

    }

    private static char[] manacherString(String string) {
        char[] chs = string.toCharArray();
        char[] chars = new char[chs.length* 2 + 1];
        int index=0;
        for (int i = 0; i <chars.length ; i++) {
            chars[i]=(i&1)==0?'#':chs[index++];
        }

        return chars;
    }

}
