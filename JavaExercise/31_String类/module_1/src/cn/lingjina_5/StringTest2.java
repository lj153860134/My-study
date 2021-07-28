package cn.lingjina_5;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019-08-21 - 10:53
 */
/*
*  需求：统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数（不考虑其他字符）
*  举例： “Hello123World”
*  结果： 2个大写字符
*        8个小写字符
*        3个数字字符
*  改进：字符串改为键盘录入方式
* */
public class StringTest2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter a String");
        String s=sc.nextLine();
        int countOfUpper=0;
        int countOfLower=0;
        int countOfNumber=0;
        for (int i = 0; i <s.length() ; i++) {
            int x=s.charAt(i);
//            char ch=s.charAt(i); //可以直接提取字符 用if比较的时候 直接可以比较字符
                                   //就不需要ASCII转换 比较数字范围了
            if(x>=65&&x<=90){
                countOfUpper++;
            }
            if(x>=97&&x<=122){
                countOfLower++;
            }
            if (x>=48&&x<=57){
                countOfNumber++;
            }

        }
        System.out.println("The String has "+countOfUpper+" upper cases");
        System.out.println("The String has "+countOfLower+" lower cases");
        System.out.println("The String has "+countOfNumber+" numbers");
    }
}
