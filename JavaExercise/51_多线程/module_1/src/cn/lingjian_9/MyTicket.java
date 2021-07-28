package cn.lingjian_9;

/**
 * @author lingjian
 * @date 2019/10/21 - 9:02 下午
 */
/*
* 方式1 实现三个窗口卖100张电影票
* */
public class MyTicket extends Thread {

    private static int tickets=100;
    public MyTicket() {
    }

    public MyTicket(String name) {
        super(name);
    }

    @Override
    public void run() {
        //为了模拟一直有票
        while(true){
            if(tickets>0){
                System.out.println(getName()+"正在出售第"+(tickets--)+"张票");
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
