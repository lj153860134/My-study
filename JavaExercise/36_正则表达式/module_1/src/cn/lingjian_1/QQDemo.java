package cn.lingjian_1;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019-09-03 - 14:32
 */
/*
 *  校检qq号码：1、要求必须是5到15位数字
 *            2、0不能是开头
 *
 * */
public class QQDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a String");
        String s = sc.nextLine();
        if (checkString1(s))
            System.out.println("correct");
        else
            System.out.println("error");

        if (checkString2(s))
            System.out.println("correct");
        else
            System.out.println("error");
    }

    public static boolean checkString1(String s) {
        char[] chs = s.toCharArray();
        boolean flag = true;
        if (chs.length >= 5 && chs.length <= 15 && chs[0] != '0') {
            //这里的0必须是单引号
            for (int i = 0; i < chs.length; i++) {
                if (!Character.isDigit(chs[i])) {
                    flag = false;
                    break;
                }
            }

        } else {
            flag = false;
        }
        return flag;
    }

    public static boolean checkString2(String s) {
        boolean flag = true;
        if (s.length()>=5&&s.length()<=15&&!s.startsWith("0")) {
                                          //这里就可以用双引号
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if (!Character.isDigit(chs[i])) {
                    flag = false;
                    break;
                }
            }

        } else {
            flag = false;
        }
        return flag;
    }
}
