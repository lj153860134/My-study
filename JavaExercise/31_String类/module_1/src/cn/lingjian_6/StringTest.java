package cn.lingjian_6;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019-08-21 - 15:15
 */
/*
*
*  需求：把一个字符串的首字母转成大写，其余为小写（只考虑英文大小写字母字符）
*       键盘录入英文字符串
*  分析：
*       A:先获取第一个字符 将其转换为大写
*       B:获取除了第一个以外的字符 将其转换为小写
*       C：将两者拼接起来
* */
public class StringTest {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Please enter a English String");
        String s=sc.nextLine();
        String s1=s.substring(0,1);  //首字母可以看做字符 也可以用字符串截取出来
        String s2=s.substring(1);
        String upperString=s1.toUpperCase();
        String lowerString=s2.toLowerCase();
        String string=upperString+lowerString;
        System.out.println(string);
        System.out.println("------");

        //一步到位法
        String result=s.substring(0,1).toUpperCase().concat(s.substring(1).toLowerCase());
        System.out.println(result);

    }
}
