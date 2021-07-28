package com.lingjian.kmp;

import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * @description: Manacher算法 字符串最长回文长度
 * @author: Ling Jian
 * @date: 2020-05-19 16:48
 **/
public class ManacherDemo {
    public static void main(String[] args) {
        String str = "abc1234321ab";
        int result = maxLcpsLength(str);
        System.out.println(result);
    }

    private static int maxLcpsLength(String str) {
        if (str == null||str.length()==0) {
            return 0;
        }
        char[] chs = manacherString(str);
        System.out.println(Arrays.toString(chs));
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
            max = Math.max(max, pArr[i]);
        }
        return max-1;
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
