package com.lingjian.concurrent.print_1_100;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @description: 两个线程轮流打印1-100 利用Semaphore
 * @author: Ling Jian
 * @date: 2020-08-21 10:42
 **/
public class printNumber3 {
    public static void main(String[] args) {
        CommonData data = new CommonData(100);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            data.printOdd();
        });
        executorService.submit(() -> {
            data.printEven();
        });
        executorService.shutdown();
    }

    static class CommonData{
        private int n;
        private Semaphore s1 = new Semaphore(1);
        private Semaphore s2 = new Semaphore(0);

        public CommonData(int n) {
            this.n = n;
        }

        public void printOdd() {
            for (int i=1; i<=n; i+=2) {
                try {
                    s1.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"------"+i);
                s2.release();
            }

        }

        public void printEven() {
            for(int i=2; i<=n; i+=2) {
                try {
                    s2.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"------"+i);
                s1.release();
            }
        }

    }
}
