package com.lingjian.concurrent.print_1_100;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-08-21 16:38
 **/
public class PrintNumber4 {
    public static void main(String[] args) {
        CommonDate data = new CommonDate();
        new Thread(()->{
            data.printThread1();
        },"Thread1").start();

        new Thread(()->{
            data.printThread2();
        },"Thread2").start();
    }



    static class CommonDate{
        private  volatile boolean flag = true;
        ReentrantLock lock = new ReentrantLock();
        private  int i=1;
        public void printThread1(){
            while(i<=100){

                    try {
                        if(flag){
                            lock.lock();
                        }else{
                            System.out.println(Thread.currentThread().getName() + "------" + i);
                            i++;
                            flag = !flag;
                            lock.unlock();


                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            }
        }

        public void printThread2(){
            while(i<=100){

                    try {
                        if(!flag){
                            lock.lock();
                        }else{
                            System.out.println(Thread.currentThread().getName() + "------" + i);
                            i++;
                            flag = !flag;
                            lock.unlock();

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            }
        }



    }
}

