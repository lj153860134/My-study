package com.lingjian.concurrent;

import java.util.concurrent.*;

/**
 * @description: 自定义线程池
 * @author: Ling Jian
 * @date: 2020-05-10 22:44
 **/
public class MyThreadPoolDemo2 {
    public static void main(String[] args) {
        ExecutorService threadPool=new ThreadPoolExecutor(2,
                5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        try {
            for (int i = 1; i <=10; i++) {

                threadPool.execute(()->{
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
