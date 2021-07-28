package com.lingjian.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 连接池
 * @author: Ling Jian
 * @date: 2020-05-10 16:32
 **/
public class MyThreadPoolDemo {
    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);  //线程池设置固定线程数
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//线程池1个线程数
        ExecutorService threadPool = Executors.newCachedThreadPool();//线程池N个线程数

        try {
            for (int i = 1; i <= 10; i++) {

                threadPool.submit(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            threadPool.shutdown();
        }
    }
}
