package com.lingjian.leetcode;

import java.util.HashMap;

/**
 * @description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
 * @author: Ling Jian
 * @date: 2020-06-18 16:00
 **/
public class Test_242 {
    public static void main(String[] args) {
        String s="anagram";
        String t = "nagaraa";
        System.out.println(isAnagram(s, t));

    }


    //遇到计算小写字母的个数 首先想到int[26] 来存储个数
    public static boolean isAnagram1(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        if(s.equals(t)){
            return true;
        }

        int[] count=new int[26];
        char[] chs1=s.toCharArray();
        char[] chs2=t.toCharArray();
        for(char ch:chs1){
            count[ch-'a']++;
        }
        for(char ch:chs2){
            count[ch-'a']--;
            if(count[ch-'a']<0){
                return false;
            }
        }
        return true;

    }


    //用HashMap
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        if(s.equals(t)){
            return true;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chs1=s.toCharArray();
        char[] chs2 = t.toCharArray();
        for (int i = 0; i <chs1.length ; i++) {
            map.put(chs1[i],map.getOrDefault(chs1[i],0)+1);
        }
        for (int i = 0; i < chs2.length ; i++) {
            if(!map.containsKey(chs2[i])){
                return false;
            }else{
                map.put(chs2[i],map.get(chs2[i])-1);
            }
        }
        for (Integer value : map.values()) {
            if(value!=0){
                return false;
            }
        }
        return true;

    }
}
