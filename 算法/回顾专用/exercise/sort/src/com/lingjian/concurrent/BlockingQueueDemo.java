package com.lingjian.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description: 阻塞队列
 * @author: Ling Jian
 * @date: 2020-05-09 19:50
 **/
public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception{
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.offer("a", 2, TimeUnit.SECONDS));
        System.out.println(queue.offer("a", 2, TimeUnit.SECONDS));
        System.out.println(queue.offer("a", 2, TimeUnit.SECONDS));
        System.out.println(queue.offer("a", 2, TimeUnit.SECONDS));
    }
}
