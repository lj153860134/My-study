package com.lingjian.concurrent;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-14 14:18
 **/
public class ProdConsumer_TraditionalDemo2 {
    public static void main(String[] args) {
        Queue<Product> queue = new ArrayDeque<>();
        for (int i = 0; i <100 ; i++) {
            //修改maxSize中的值
            new Thread(new Producer(queue,2)).start();
            new Thread(new Consumer(queue,2)).start();
        }
    }


    //生产者
    static class Producer implements Runnable{
        private Queue<Product> queue;
        private int maxSize;

        public Producer(Queue<Product> queue, int maxSize) {
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            synchronized (queue) {
                //这里一定要用while
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("生产者"+Thread.currentThread().getName()+"等待中-----  Queue已经到达最大值 无法生产");
                        queue.wait();
                        System.out.println("生产者"+Thread.currentThread().getName()+"退出等待");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(queue.size()==0){
                    queue.notifyAll();
//                    System.out.println("------生产者唤醒其他线程------");
                }
                Random random = new Random();
                Integer i = random.nextInt();
                queue.add(new Product("产品" + i.toString()));
                System.out.println("生产者" + Thread.currentThread().getName() + "生产了产品" + i.toString());
            }
        }
    }


    //消费者
    static class Consumer implements Runnable{
        private Queue<Product> queue;
        private int maxSize;

        public Consumer(Queue<Product> queue, int maxSize) {
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            synchronized (queue) {
                //这里一定要用while
                while (queue.size() == 0) {
                    try {
                        System.out.println("消费者"+Thread.currentThread().getName()+"等待中-----  Queue已缺货 无法消费");
                        queue.wait();
                        System.out.println("消费者"+Thread.currentThread().getName()+"退出等待");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(queue.size()==maxSize){
                    queue.notifyAll();
//                    System.out.println("------消费者唤醒其他线程------");
                }
                Product product = queue.poll();
                System.out.println("消费者" + Thread.currentThread().getName() + "消费了" + product.getName());
            }
        }

    }

    //共享资源类
    static class Product {
        public String name;

        public Product(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
