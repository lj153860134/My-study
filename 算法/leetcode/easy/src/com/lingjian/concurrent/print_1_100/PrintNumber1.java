package com.lingjian.concurrent.print_1_100;

/**
 * @description: 两个线程轮流打印数字1-100  利用多线程
 * @author: Ling Jian
 * @date: 2020-08-19 09:26
 **/
public class PrintNumber1 {
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
        private  int i=1;
        public void printThread1(){
            while(i<=100){
                synchronized (this){
                    try {
                        if(flag){
                            this.wait();
                        }else{
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

         public void printThread2(){
             while(i<=100){
                 synchronized (this){
                     try {
                         if(!flag){
                             this.wait();
                         }else{
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






