package com.lingjian.jianzhi;

/**
 * @description: 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）
 *                  例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值
 *                  但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是
 * @author: Ling Jian
 * @date: 2020-06-22 16:41
 **/
public class Test_20 {
    public static void main(String[] args) {
        String s = "95.94f";
        double num = Double.parseDouble(s);
        System.out.println(num);
        boolean res = isNumber(s);
        System.out.println(res);
    }
    public static boolean isNumber(String s) {
        if(s.endsWith("f")){
            return false;
        }
        try {
            double num = Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

}
