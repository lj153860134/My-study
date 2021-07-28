package com.lingjian.concurrent;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-05-08 21:04
 **/
public class MyCacheDemo {

    public static void main(String[] args) {
        MyCaChe cache = new MyCaChe();
        for (int i = 0; i < 5; i++) {
            final int temp=i;
            new Thread(()->cache.put(temp,temp),String.valueOf(temp)).start();
        }
        for (int i = 0; i < 5; i++) {
            final int temp=i;
            new Thread(()->cache.get(temp),String.valueOf(temp)).start();
        }

    }

}

class MyCaChe {
    private volatile HashMap<Integer, Integer> hashMap = new HashMap<>();
    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    public void put(Integer a, Integer b) {
        rwlock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在写入 " + a);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hashMap.put(a, b);
            System.out.println(Thread.currentThread().getName()+"写入完成 "+a);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwlock.writeLock().unlock();

        }
    }


    public void get(Integer a) {
        rwlock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在读取 " + a);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int result = hashMap.get(a);
            System.out.println(Thread.currentThread().getName()+"读取完成 "+result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwlock.readLock().unlock();
        }


    }



}



