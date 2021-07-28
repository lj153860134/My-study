package cn.lingjian_5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019/10/28 - 3:50 下午
 */
public class SendThred implements Runnable{

    private DatagramSocket ds;

    public SendThred(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {

            Scanner sc = new Scanner(System.in);
            while (true) {
//                System.out.println("Please enter your message");
                String message = sc.nextLine();
                byte[] bys = message.getBytes();
                DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName("10.192.49.121"), 12306);
                if (!message.equals("886")) {
                    ds.send(dp);
                } else {
                    ds.send(dp);
                    break;
                }

            }
            ds.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
