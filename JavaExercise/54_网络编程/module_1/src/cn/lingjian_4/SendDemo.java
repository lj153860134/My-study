package cn.lingjian_4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019/10/25 - 3:49 下午
 */
/*
* 从键盘录入数据进行发送 如果输入886
* 客户端就结束输入数据
* */
public class SendDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket();

        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("Please enter your message");
            String message = sc.nextLine();
            byte[] bys = message.getBytes();
            DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName("10.192.49.121"), 10099);
            if (!message.equals("886")) {
                ds.send(dp);
            }else{
                ds.send(dp);
                break;
            }

        }
        ds.close();
    }
}
