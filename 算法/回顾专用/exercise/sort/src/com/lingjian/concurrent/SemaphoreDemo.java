package com.lingjian.concurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @description: 信号灯模拟抢车位
 * @author: Ling Jian
 * @date: 2020-05-09 10:37
 **/
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);  //3个停车位
        for (int i = 1; i <= 6; i++) {    //6辆车
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢到车位");
                    try {
                        TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
                    System.out.println(Thread.currentThread().getName() + "\t停车2s后 离开车位");
                } catch (Exception e) {
                    e.printStackTrace();
                }finally{
                    semaphore.release();
                }
               },String.valueOf(i)).start();
        }
    }
}
