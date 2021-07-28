package cn.lingjian_3;

import java.util.Date;

/**
 * @author lingjian
 * @date 2019/10/21 - 4:56 下午
 */
public class ThreadSleep extends Thread{
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(getName() + ":" + i+new Date());

            //睡眠
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
