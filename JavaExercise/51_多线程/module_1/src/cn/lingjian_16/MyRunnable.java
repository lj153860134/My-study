package cn.lingjian_16;

/**
 * @author lingjian
 * @date 2019/10/22 - 7:31 下午
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
