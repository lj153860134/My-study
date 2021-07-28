package cn.lingjian_3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author lingjian
 * @date 2019/10/25 - 3:22 下午
 */
/*
* UTD优化编程版本
* */
public class SendDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket();
        byte[] bys="凌健最爱的人是徐小萌".getBytes();
        DatagramPacket dp=new DatagramPacket(bys,bys.length,
                InetAddress.getByName("127.0.0.1"),10098);

        ds.send(dp);
        ds.close();
    }

}
