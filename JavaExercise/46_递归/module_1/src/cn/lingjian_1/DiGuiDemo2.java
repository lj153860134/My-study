package cn.lingjian_1;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019/9/26 - 8:20 下午
 */
/*
* 递归求斐波那契数列
*
* */
public class DiGuiDemo2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter a integer");
        int n=sc.nextInt();
        for (int i = 1; i <=n ; i++) {
            System.out.print(fei(i)+" ");

        }
    }

    public static int fei(int n) {
        if (n == 1||n==2)
            return 1;
         else {
            return fei(n - 1) + fei(n - 2);
        }

    }
}
