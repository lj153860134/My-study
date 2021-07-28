package cn.lingjian_10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lingjian
 * @date 2019/10/21 - 9:16 下午
 */
/*
 * 方式2 实现三个窗口卖100张电影票
 * */
public class MyTickets implements Runnable {

    private int tickets = 100;
    private Lock lock=new ReentrantLock();

    @Override
    public void run() {

        //为了模拟一直有票
        while (true) {
            //加锁
            try {
                lock.lock();

                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }finally {
            //释放锁
            lock.unlock();
            }
        }
    }


}
