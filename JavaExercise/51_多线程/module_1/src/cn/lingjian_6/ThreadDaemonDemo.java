package cn.lingjian_6;

import javax.management.remote.TargetedNotification;

/**
 * @author lingjian
 * @date 2019/10/21 - 7:58 下午
 */
public class ThreadDaemonDemo {
    public static void main(String[] args) {
        ThreadDaemon td1=new ThreadDaemon("凌健");
        ThreadDaemon td2=new ThreadDaemon("凌立宏");
        //设置守护线程
        td1.setDaemon(true);
        td2.setDaemon(true);

        td1.start();
        td2.start();



        Thread.currentThread().setName("王杰");
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);

        }
    }
}
