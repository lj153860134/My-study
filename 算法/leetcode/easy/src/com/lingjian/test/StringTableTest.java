package com.lingjian.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-04-16 23:23
 **/
public class StringTableTest {
    public static void main(String[] args) {
        String s2 = new String("c") + new String("d");
        String s1 = "cd";
        String s3=s2.intern();
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s2==s3);



    }
}
