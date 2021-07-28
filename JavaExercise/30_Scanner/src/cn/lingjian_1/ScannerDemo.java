package cn.lingjian_1;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019-08-20 - 09:17
 */
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a integer ");
        if (sc.hasNextInt()) {
            int x = sc.nextInt();
            System.out.println("your number is " + x);
        }else{
            System.out.println("your number is not a integer");
        }

    }
}
