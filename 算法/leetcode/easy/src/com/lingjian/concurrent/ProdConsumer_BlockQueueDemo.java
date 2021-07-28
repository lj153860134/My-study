package com.lingjian.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 阻塞队列版的生产者消费者模式
 * @author: Ling Jian
 * @date: 2020-05-10 14:02
 **/
public class ProdConsumer_BlockQueueDemo {

    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<String>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
           },"Producer").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Consumer").start();

        try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5s时间到 main线程叫停 生产消费活动结束");
        myResource.stop();
    }
}

class MyResource {
    private volatile boolean flag=true;
    private AtomicInteger atomicInteger = new AtomicInteger();


    BlockingQueue<String> blockingQueue=null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    //生产者
    public void myProd() throws Exception {
        String data = null;
        boolean retValue;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            retValue  = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"成功");
            }else{
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t flag=false 生产者动作结束");
    }

    // 消费者
    public void myConsumer() throws Exception {
        String result=null;
        while (flag) {
            result=blockingQueue.poll(2, TimeUnit.SECONDS);
            if(null==result||result.equalsIgnoreCase("")){
                flag=false;
                System.out.println(Thread.currentThread().getName() + "\t 超过2s未取到 消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t 消费队列"+result+"成功");
        }

    }

    public void stop()  {
        this.flag = false;
    }
}
