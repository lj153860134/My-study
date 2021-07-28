package cn.lingjian_19;

/**
 * @author lingjian
 * @date 2019/10/22 - 8:16 下午
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //匿名内部类继承Thread类来实现多线程
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }.start();

        //匿名内部类实现Runnable接口实现多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+":"+i);

                }
            }
        }).start();

        //两种实现方式结合起来

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("hello :"+i);

                }
            }
        }){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("world :"+i);
                }
            }
        }.start();

    }
}
