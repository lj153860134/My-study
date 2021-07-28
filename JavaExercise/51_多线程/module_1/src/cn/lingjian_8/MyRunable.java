package cn.lingjian_8;

/**
 * @author lingjian
 * @date 2019/10/21 - 8:43 下午
 */
public class MyRunable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
