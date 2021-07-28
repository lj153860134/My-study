package cn.lingjian_7;

/**
 * @author lingjian
 * @date 2019/10/21 - 8:20 下午
 */
public class ThreadStopDemo {
    public static void main(String[] args) {
        ThreadStop ts=new ThreadStop("凌健");
        ts.start();
        try {
            Thread.sleep(3000);
//            ts.stop();
            ts.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
