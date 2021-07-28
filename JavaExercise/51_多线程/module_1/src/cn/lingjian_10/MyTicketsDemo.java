package cn.lingjian_10;

import cn.lingjian_10.MyTickets;

/**
 * @author lingjian
 * @date 2019/10/21 - 9:19 下午
 */
public class MyTicketsDemo {
    public static void main(String[] args) {
        MyTickets mt=new MyTickets();

        Thread t1=new Thread(mt,"第一窗口");
        Thread t2=new Thread(mt,"第二窗口");
        Thread t3=new Thread(mt,"第三窗口");

        t1.start();
        t2.start();
        t3.start();
    }
}
