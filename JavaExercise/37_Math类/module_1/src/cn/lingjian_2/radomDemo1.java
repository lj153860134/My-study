package cn.lingjian_2;

import java.util.Random;

/**
 * @author lingjian
 * @date 2019-09-11 - 14:55
 */
/*
* Random类的概述和方法使用
*
* */
public class radomDemo1 {
    public static void main(String[] args) {
        Random r=new Random();
        for (int i = 0; i <10; i++) {
            int number=r.nextInt();
            System.out.println(number);
        }
        for (int i = 0; i <100; i++) {
            int number=r.nextInt(100)+1;
            System.out.println(number);
        }
    }
}
