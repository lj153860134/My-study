package cn.lingjian_1;

/**
 * @author lingjian
 * @date 2019/10/21 - 3:08 下午
 */
public class MyThread extends Thread {

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
//        System.out.println("helloworld");
        for (int i = 0; i <200 ; i++) {
            System.out.println(getName()+":"+i);
        }
    }
}
