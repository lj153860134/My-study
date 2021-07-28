package cn.lingjian_8;

/**
 * @author lingjian
 * @date 2019/10/21 - 8:41 下午
 */
public class MyRunableDemo {
    public static void main(String[] args) {

        MyRunable mr = new MyRunable();
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);

        t1.start();
        t2.start();
    }


}
