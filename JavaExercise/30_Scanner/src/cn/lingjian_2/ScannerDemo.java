package cn.lingjian_2;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019-08-20 - 09:51
 */
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //获取两个int类型的值
        /*int x=sc.nextInt();
        int y=sc.nextInt();
        System.out.println("x: "+x+", y: "+y);
        System.out.println("--------");*/

        // 获取两个String类型的值
        /*String s1=sc.nextLine();
        String s2=sc.nextLine();
        System.out.println("s1: "+s1+" s2: "+s2);
        System.out.println("--------");*/

        //先获取一个字符串 再获取一个int值
        /*String s1=sc.nextLine();
        int x=sc.nextInt();
        System.out.println("s1: "+s1+" x: "+x);
        System.out.println("--------");*/

        //先获取一个int值，再获取一个字符串类
        int a=sc.nextInt();
        String s1=sc.nextLine();
        System.out.println("a: "+a+" s1: "+s1);//在这里出现问题 会接受\r(回车键）

    }
}
