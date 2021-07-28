package cn.lingjian_6;

/**
 * @author lingjian
 * @date 2019/11/5 - 2:58 下午
 */
public class RunnableDemo {
    public static void main(String[] args) {
        //Lambda
        startThread(()->{
            System.out.println(Thread.currentThread().getName());
        });

        //Lambda简化版
        startThread(()->System.out.println(Thread.currentThread().getName()));
}

    private static void startThread(Runnable r){
        new Thread(r).start();
    }
}
