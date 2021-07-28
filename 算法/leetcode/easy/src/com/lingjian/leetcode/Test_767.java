package com.lingjian.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @description: 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同
 *               若可行，输出任意可行的结果。若不可行，返回空字符串。
 * @author: Ling Jian
 * @date: 2020-05-27 17:32
 **/
public class Test_767 {
    public static void main(String[] args) {
        String s = "aaab";
        String res = reorganizeString(s);
        System.out.println(res);
    }

    public static String reorganizeString(String s) {
        if (s.length() == 1) {
            return s;
        }
        int threshold = (s.length() + 1) >> 1;
        PriorityQueue<newChar> maxQueue = new PriorityQueue<>(new Comparator<newChar>() {
            @Override
            public int compare(newChar o1, newChar o2) {
                return o2.count - o1.count;
            }
        });

        int [] counts = new int[26];
        char[] strs = s.toCharArray();
        for (char ch : strs) {
            counts[ch-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(counts[i]>threshold){
                return "";
            }
            if (counts[i] > 0) {
                maxQueue.offer(new newChar(counts[i], (char) ('a' + i)));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(maxQueue.size()>1) {
            newChar char1 = maxQueue.poll();
            newChar char2 = maxQueue.poll();
            sb.append(char1.ch);
            sb.append(char2.ch);
            if (--char1.count >0 )
                maxQueue.offer(char1);
            if (--char2.count >0 )
                maxQueue.offer(char2);
        }
        if(maxQueue.size()>0)
            sb.append(maxQueue.poll().ch);

        return sb.toString();

    }

    public static class newChar{
        public int count;
        public char ch;

        public newChar(int count, char ch) {
            this.count = count;
            this.ch = ch;
        }
    }
}
