package com.lingjian.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 传统的生产者消费者模式
 * @author: Ling Jian
 * @date: 2020-05-09 21:15
 **/
public class ProdConsumer_TraditionalDemo {
    public static void main(String[] args) {
        shareData2 shareData = new shareData2();
        for (int i = 0; i <5 ; i++) {
            new Thread(()->{
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"AAA").start();
        }

        for (int i = 0; i <5 ; i++) {
            new Thread(()->{
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"BBB").start();
        }

        for (int i = 0; i <5 ; i++) {
            new Thread(()->{
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"CCC").start();
        }

        for (int i = 0; i <5 ; i++) {
            new Thread(()->{
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"DDD").start();
        }
    }
}

class shareData{
    private int num=0;
    Object o = new Object();
    public void increment () throws Exception {
        synchronized (o){
            while(num!=0){
                o.wait();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            o.notifyAll();
        }
    }

    public void decrement () throws Exception {
        synchronized (o){
            while(num==0){
                o.wait();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            o.notifyAll();
        }
    }
}

class shareData2{
    private int num=0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            while (num!=0){
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            while (num==0){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
