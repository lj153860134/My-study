package cn.lingjian_1;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019-09-05 - 10:41
 */
/*
*  正则表达式判断邮箱是否正确
*
* */
public class RegexDemo3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter your e-mail address");
        String s=sc.nextLine();
        if(checkEmail(s))
            System.out.println("true");
        else
            System.out.println("false");
    }

    public static boolean checkEmail(String s) {
//        return s.matches("[a-zA-Z_0-9]+@[a-zA-Z_0-9]{2,6}(\\.[a-zA-Z_0-9]{2,3})+");
        return s.matches("\\w+@\\w{2,6}(\\.\\w{2,3})+");
    }
}
