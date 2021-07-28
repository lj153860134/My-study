package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019/10/21 - 4:37 下午
 */
public class ThreadPriority extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <200 ; i++) {
            System.out.println(getName()+":"+i);
        }
    }
}
