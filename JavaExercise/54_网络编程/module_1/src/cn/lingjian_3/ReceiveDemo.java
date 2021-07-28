package cn.lingjian_3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author lingjian
 * @date 2019/10/25 - 3:15 下午
 */
public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket(10098);

        byte[] bys=new byte[1024];
        DatagramPacket dp=new DatagramPacket(bys,bys.length);

        ds.receive(dp);

        String ip=dp.getAddress().getHostAddress();


        String str=new String(dp.getData(),0,dp.getLength());
        System.out.println(ip+"数据为: "+str);

        ds.close();
    }
}
