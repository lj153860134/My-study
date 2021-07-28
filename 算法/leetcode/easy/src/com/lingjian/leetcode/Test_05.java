package com.lingjian.leetcode;

import java.util.Arrays;

/**
 * @description: 字符串最长回文半径
 * @author: Ling Jian
 * @date: 2020-04-16 21:36
 **/
public class Test_05 {
    public static void main(String[] args) {
        String s = "412213";
//        String result = maxLcpLength1(s); //暴力解法
        String result = maxLcpLength2(s); //暴力解法
        System.out.println(result);
    }


    //暴力求解
    public static String maxLcpLength1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chs = strToChar(s);
        String result = "";
        int max = 0;
        for (int i = 0; i < chs.length; i++) {
            int count = 0;
            for (int j = 0; i + j < chs.length && i - j >= 0; j++) {
                if (chs[i - j] == chs[i + j]) {
                    count++;
                } else {
                    break;
                }
            }
            if (count > max) {
                result = s.substring((i + 1 - count) / 2, (i + count) / 2);
                max = count;
            }

        }
        return result;

    }


    //Manacher算法
    public static String maxLcpLength2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chs = strToChar(s);
        int[] arr = new int[chs.length];
        int c = -1;
        int r = -1;
        int max = 0;
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r > i ? Math.min(arr[2 * c - i], r - i) : 1;
            while (i + arr[i] < arr.length && i - arr[i] >= 0) {
                if (chs[i + arr[i]] == chs[i - arr[i]]) {
                    arr[i]++;
                } else {
                    break;
                }
            }
            if (i + arr[i] > r) {
                r = i + arr[i];
                c = i;
            }
            if (arr[i] > max) {
                result = s.substring((i + 1 - arr[i]) / 2, (i + arr[i]) / 2);
                max = arr[i];
            }
        }

        return result;


    }


    //转换字符串(不需要）
    public static char[] strToChar(String s) {
        char[] chs = s.toCharArray();
        char[] result = new char[chs.length * 2 + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i % 2 == 0 ? '#' : chs[i / 2];
        }


        return result;

    }

    //恢复字符串
    public static String charToStr(char[] chs, int count, int i) {
        String str = "";
        for (int j = i + 1 - count; j < i + count - 1; j++) {
            if (chs[j] != '#') {
                str += chs[j];
            }
        }
        return str;

    }


    //另一种好理解的解法

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
//         查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         定位中间部分的最后一个字符
        int ans = high;
//         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }


}
