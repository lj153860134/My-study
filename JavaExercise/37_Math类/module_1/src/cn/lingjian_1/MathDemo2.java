package cn.lingjian_1;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019-09-11 - 14:38
 */
/*
* 需求：实现获取任意范围内的随机数
*
* */
public class MathDemo2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the min integer");
        int start=sc.nextInt();
        System.out.println("Please enter the max integer");
        int end=sc.nextInt();
        System.out.println("Please enter the number");
        int z=sc.nextInt();
        if(start>end)
            System.out.println("Error");
        randomNumer(start,end,z);
    }


    public static void randomNumer(int x,int y,int z){
        int gap=y-x+1;
        for (int i = 0; i <z ; i++) {
            int random=(int)(Math.random()*gap+x);
            System.out.println(random);

        }
    }
}
