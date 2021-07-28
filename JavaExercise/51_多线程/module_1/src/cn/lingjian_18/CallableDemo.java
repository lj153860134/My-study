package cn.lingjian_18;

import java.util.concurrent.*;

/**
 * @author lingjian
 * @date 2019/10/22 - 7:59 下午
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool= Executors.newFixedThreadPool(3);
        Future<Integer> f1=pool.submit(new MyCallable(100));
        Future<Integer> f2=pool.submit(new MyCallable(10));
        System.out.println(f1.get());
        System.out.println(f2.get());

        pool.shutdown();

    }
}
