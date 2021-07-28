package com.lingjian.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-05-10 15:42
 **/
public class CallableDemo {
    public static void main(String[] args) {
        new Thread(new FutureTask<Integer>(new MyThread()
        ),"AA").start();
    }
}

class MyThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("come in Callable");
        return 1024;
    }
}
