package com.lingjian.concurrent.print_A_B_C;

/**
 * @description: 轮流打印ABC
 * @author: Ling Jian
 * @date: 2020-08-24 11:01
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

        new Thread(()->{
            data.printThread3();
        },"Thread3").start();
    }




    static class CommonDate{

        private  int i=0;
        public void printThread1(){
            while(i<100){
                synchronized (this){
                    try {
                        if(i%3!=0){
                            this.wait();
                        }else{
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

        public void printThread2(){
            while(i<100){
                synchronized (this){
                    try {
                        if(i%3!=1){
                            this.wait();
                        }else{
                            System.out.println(Thread.currentThread().getName() + " B" );
                            i++;
                            this.notifyAll();

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void printThread3(){
            while(i<100){
                synchronized (this){
                    try {
                        if(i%3!=2){
                            this.wait();
                        }else{
                            System.out.println(Thread.currentThread().getName() + " C" );
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
