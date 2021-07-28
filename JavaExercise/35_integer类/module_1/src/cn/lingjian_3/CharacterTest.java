package cn.lingjian_3;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019-09-03 - 10:50
 */
/*
*用Character类中的成员方法判断字符串中大小写字母和数字的个数
*
* */
public class CharacterTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter a String");
        String s=sc.nextLine();
        judgeString(s);
    }

    public static void judgeString(String s) {
        char[] chs=s.toCharArray();
        int upperCount=0;
        int lowerCount=0;
        int digitCount=0;
        for (int i = 0; i <chs.length ; i++) {
            if(Character.isUpperCase(chs[i]))
            upperCount++;
            if(Character.isLowerCase(chs[i]))
                lowerCount++;
            if(Character.isDigit(chs[i]))
                digitCount++;
        }
        System.out.println("Upper: "+upperCount);
        System.out.println("Lower: "+lowerCount);
        System.out.println("Digit: "+digitCount);
    }
}
