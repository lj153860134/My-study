package com.lingjian.interview.jingdian;

/**
 * @description: 你有两个字符串
 *              即pattern和value
 *              pattern字符串由字母"a"和"b"组成
 *              用于描述字符串中的模式
 *              例如，字符串"catcatgocatgo"匹配模式"aabab"
 *              （其中"cat"是"a"，"go"是"b"）
 *              该字符串也匹配像"a"、"ab"和"b"这样的模式
 *              但需注意"a"和"b"不能同时表示相同的字符串
 *              编写一个方法判断value字符串是否匹配pattern字符串
 * @author: Ling Jian
 * @date: 2020-06-22 14:53
 **/
public class Test_16_18 {
    public static void main(String[] args) {
        String pattern = "abba";
        String value="dogcatcatdog";
        boolean res = patternMatching(pattern, value);
        System.out.println(res);
    }

    public static boolean patternMatching(String pattern, String value) {
        if(pattern.length()==1){
            return true;
        }
        if(pattern.length()==0&&value.length()!=0){
            return false;
        }
        if(pattern.length()==0&&value.length()==0){
            return true;
        }

        return true;


    }
}
