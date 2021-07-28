package com.lingjian.jianzhi;

/**
 * @description: 在字符串s中找出第一个只出现一次的字符
 *               如果没有，返回一个单空格
 *               s 只包含小写字母。
 * @author: Ling Jian
 * @date: 2020-07-07 17:42
 **/
public class Test_50 {
    public static void main(String[] args) {
        String s="abaccdeff";
        char ch=firstUniqChar(s);
        System.out.println(ch);
    }

    public static char firstUniqChar(String s) {
        if(s==null||s.equals("")){
            return ' ';
        }
        int[] count = new int[26];
        char[] chs = s.toCharArray();
        for (int i = 0; i <chs.length ; i++) {
            count[chs[i]-'a']++;
        }
        for (int i = 0; i <chs.length ; i++) {
            if(count[chs[i]-'a']==1){
                return chs[i];
            }
        }
        return ' ';
    }
}
