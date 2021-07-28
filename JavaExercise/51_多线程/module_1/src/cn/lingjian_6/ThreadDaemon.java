package cn.lingjian_6;

/**
 * @author lingjian
 * @date 2019/10/21 - 7:57 下午
 */
public class ThreadDaemon extends Thread {

    public ThreadDaemon() {
    }

    public ThreadDaemon(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+":"+i);
            yield();
        }
    }
}
