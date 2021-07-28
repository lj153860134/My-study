package com.lingjian.leetcode;

import com.sun.java.swing.plaf.windows.resources.windows;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;

/**
 * @description: 给你一个字符串 S
 * 一个字符串 T
 * 请你设计一种算法
 * 可以在 O(n) 的时间复杂度内
 * 从字符串 S 里面找出
 * 包含 T 所有字符的最小子串。
 * @author: Ling Jian
 * @date: 2020-08-21 23:27
 **/
public class Test_76 {
    public static void main(String[] args) {
        String s = "AB";
        String t = "A";
        String res = minWindow(s, t);
        System.out.println(res);
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        char[] chs1 = s.toCharArray();
        char[] chs2 = t.toCharArray();
        int count = 0;
        for (char c : chs2) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int start=0;
        int len = Integer.MAX_VALUE;
        while (right < chs1.length) {
            char c = chs1[right];
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).compareTo(need.get(c))==0) {
                    count++;
                }
            }
            while (count == need.size()) {
                if(right-left<len){
                    start=left;
                    len = right - left;
                }

                char d = chs1[left++];

                if (need.containsKey(d)) {
                    if (window.get(d).compareTo(need.get(d))==0) {
                        count--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return  len==Integer.MAX_VALUE? "" : s.substring(start, start+len);
    }

    //用数组代替map
    public String minWindow2(String s, String t) {

        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length())
            return "";

        int[] need = new int[128];
        int[] window = new int[128];

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int needSize = 0;
        for (int count : need) {

            if (count != 0)
                needSize++;
        }

        int left = 0, right = 0;
        int valid = 0;

        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {

            char c = s.charAt(right);
            right++;

            if (need[c] != 0) {

                window[c]++;

                if (window[c] == need[c])
                    valid++;
            }

            while (valid == needSize) {

                if (right-left < len) {

                    start = left;
                    len = right-left;
                }

                char d = s.charAt(left);
                left++;

                if (need[d] != 0) {

                    if (window[d] == need[d])
                        valid--;

                    window[d]--;
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }

}
