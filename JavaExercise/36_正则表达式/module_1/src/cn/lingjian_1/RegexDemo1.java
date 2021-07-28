package cn.lingjian_1;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019-09-03 - 15:04
 */
public class RegexDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a String");
        String s = sc.nextLine();
        if (checkQQ(s))
            System.out.println("correct");
        else
            System.out.println("error");


    }

    public static boolean checkQQ(String s) {
        return s.matches("[1-9][0-9]{4,14}");
    }
}
