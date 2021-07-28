package cn.lingjian_9;

/**
 * @author lingjian
 * @date 2019/10/21 - 9:10 下午
 */
public class MyTicketDemo {
    public static void main(String[] args) {
        MyTicket mt1=new MyTicket("第一窗口");
        MyTicket mt2=new MyTicket("第二窗口");
        MyTicket mt3=new MyTicket("第三窗口");

        mt1.start();
        mt2.start();
        mt3.start();
    }
}
