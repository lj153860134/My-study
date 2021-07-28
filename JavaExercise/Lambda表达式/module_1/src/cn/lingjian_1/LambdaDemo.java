package cn.lingjian_1;

/**
 * @author lingjian
 * @date 2019/11/4 - 8:21 下午
 */
public class LambdaDemo {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("多线程启动");
        }).start();
    }
}
