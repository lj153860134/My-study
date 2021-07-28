package cn.lingjian_3;

/**
 * @author lingjian
 * @date 2019/10/21 - 7:40 下午
 */
public class ThreadSleepDemo {
    public static void main(String[] args) {
        ThreadSleep ts1=new ThreadSleep();
        ThreadSleep ts2=new ThreadSleep();

        ts1.start();
        ts2.start();
    }
}
