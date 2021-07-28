package cn.lingjian_17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lingjian
 * @date 2019/10/22 - 7:45 下午
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService pool= Executors.newFixedThreadPool(2);
        pool.submit(new MyCallable());
        pool.submit(new MyCallable());

        pool.shutdown();

    }
}
