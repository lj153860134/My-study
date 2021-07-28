package com.lingjian.concurrent.print_A_B_C;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 两个线程轮流打印1-100  利用线程池
 * @author: Ling Jian
 * @date: 2020-08-21 10:12
 **/
public class PrintNumber2 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CommonDate date = new CommonDate();
        service.execute(() -> {
            date.printThread1();
        });
        service.execute(() -> {
            date.printThread2();

        });

        service.execute(() -> {
            date.printThread3();

        });

        service.shutdown();
    }

    static class CommonDate {

        private int i = 0;

        public void printThread1() {
            while (i < 99) {
                synchronized (this) {
                    try {
                        if (i % 3 != 0) {
                            this.wait();
                        } else {
                            System.out.println(Thread.currentThread().getName() + " A");
                            i++;

                            this.notifyAll();

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void printThread2() {
            while (i < 99) {
                synchronized (this) {
                    try {
                        if (i % 3 != 1) {
                            this.wait();
                        } else {
                            System.out.println(Thread.currentThread().getName() + " B");
                            i++;
                            this.notifyAll();

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void printThread3() {
            while (i < 99) {
                synchronized (this) {
                    try {
                        if (i % 3 != 2) {
                            this.wait();
                        } else {
                            System.out.println(Thread.currentThread().getName() + " C");
                            i++;
                            this.notifyAll();

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }
}
