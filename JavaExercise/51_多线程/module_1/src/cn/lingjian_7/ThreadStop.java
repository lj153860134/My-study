package cn.lingjian_7;

import java.util.Date;

/**
 * @author lingjian
 * @date 2019/10/21 - 8:17 下午
 */
public class ThreadStop extends Thread{

    public ThreadStop() {
    }

    public ThreadStop(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("开始执行"+new Date());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
//            System.out.println("线程被终止了");
        }
        System.out.println("结束执行"+new Date());
    }
}
