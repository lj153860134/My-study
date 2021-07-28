package cn.lingjian_5;

/**
 * @author lingjian
 * @date 2019/10/21 - 7:47 下午
 */
public class ThreadYield extends Thread {
    public ThreadYield() {
    }

    public ThreadYield(String name) {
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
