package com.lingjian.test;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-08-21 17:19
 **/
public class Test_1 {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i <20 ; i++) {
            System.out.println((int)(Math.random()*5));
        }
        System.out.println("========");
        for (int i = 0; i <20 ; i++) {
            System.out.println((int)(Math.random()*4+1));
        }

        System.out.println("========");
        for (int i = 0; i <20 ; i++) {
            System.out.println((int)(Math.random()*3+2));
        }
    }


}
