package com.lingjian.concurrent;

import com.sun.xml.internal.xsom.impl.ForeignAttributesImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @description: 两个线程轮流打印数字1-100
 * @author: Ling Jian
 * @date: 2020-08-19 09:26
 **/
public class PrintNumber {
    public static void main(String[] args) {
        solution();
    }

    //用2个线程打印(不用线程池) 加锁
    public static void solution() {
        int i=1;
        for (int j = 0; j <2 ; j++) {
            final int num = j;
            new Thread(()->{
                print(i);
               },"Thread"+num).start();
        }

    }
    public static synchronized void print(int i){
        System.out.println(i++);
    }


}






