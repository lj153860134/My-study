package com.lingjian.concurrent.print_1_100;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 两个线程轮流打印1-100  利用线程池
 * @author: Ling Jian
 * @date: 2020-08-21 10:12
 **/
public class PrintNumber2 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        CommonDate date = new CommonDate();
        service.execute(()-> {
                date.printThread1();
        });
        service.execute(()-> {
                date.printThread2();

        });

        service.shutdown();
    }

    static class CommonDate {
        private volatile boolean flag = true;
        private int i = 1;

        public void printThread1() {
            while (i <= 100) {
                synchronized (this) {
                    try {
                        if (flag) {
                            this.wait();
                        } else {
                            System.out.println(Thread.currentThread().getName() + "------" + i);
                            i++;
                            flag = !flag;
                            this.notify();

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void printThread2() {
            while (i <= 100) {
                synchronized (this) {
                    try {
                        if (!flag) {
                            this.wait();
                        } else {
                            System.out.println(Thread.currentThread().getName() + "------" + i);
                            i++;
                            flag = !flag;
                            this.notify();

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
