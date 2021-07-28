package com.lingjian.leetcode;

/**
 * @description: 检测大写字母
 * @author: Ling Jian
 * @date: 2020-05-26 15:55
 **/
public class Test_520 {
    public static void main(String[] args) {
        String word="g";
        boolean res=detectCapitalUse(word);
        System.out.println(res);
}

    private static boolean detectCapitalUse(String word) {
        char[] chs = word.toCharArray();
        if(chs.length==1){
            return true;
        }
        if(isUpper(chs[0])){
            if(isUpper(chs[1])){
                for (int i = 2; i <chs.length ; i++) {
                    if(!isUpper(chs[i])){
                        return false;
                    }
                }
                return true;
            }else{
                for (int i = 2; i <chs.length ; i++) {
                    if(isUpper(chs[i])){
                        return false;
                    }
                }
                return true;
            }
        }else{
            for (int i = 1; i <chs.length ; i++) {
                if(isUpper(chs[i])){
                    return false;
                }
            }
            return true;
        }


    }

    private static boolean isUpper(char ch){
        return ch>=65&&ch<=90;
    }
}
