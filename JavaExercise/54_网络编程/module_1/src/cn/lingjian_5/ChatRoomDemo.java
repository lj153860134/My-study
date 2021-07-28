package cn.lingjian_5;

import java.io.IOException;
import java.net.DatagramSocket;

/**
 * @author lingjian
 * @date 2019/10/28 - 3:42 下午
 */
/*
* 通过多线程改进聊天程序 可以实现在一个窗口发送和接收数据
* */
public class ChatRoomDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket dsSend=new DatagramSocket();
        DatagramSocket dsReceive=new DatagramSocket(12306);

        SendThred st=new SendThred(dsSend);
        ReceiveThred rt=new ReceiveThred(dsReceive);

        Thread t1=new Thread(st);
        Thread t2=new Thread(rt);

        t1.start();
        t2.start();
    }
}
