package com.lingjian.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-05-09 10:21
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙");
        });

        for (int i = 1; i <=7; i++) {
            final int temp=i;
//            new Thread(()->{
//                System.out.println(Thread.currentThread().getName()+"\t收集到第"+i+"龙珠");
//                try {
//                    cyclicBarrier.await();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//               },String.valueOf(i)).start();

            new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"\t收集到第"+temp+"龙珠");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
               }},String.valueOf(temp)).start();
        }
    }
}
