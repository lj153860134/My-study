package cn.lingjian_16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lingjian
 * @date 2019/10/22 - 7:23 下午
 */
public class ExecutorsDemo {
    public static void main(String[] args) {
        ExecutorService pool=Executors.newFixedThreadPool(2);

        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());

        //结束线程池
        pool.shutdown();
    }
}
