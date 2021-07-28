package cn.lingjian_2;

import java.io.IOException;
import java.net.*;

/**
 * @author lingjian
 * @date 2019/10/25 - 2:29 下午
 */
/*
* UDP协议发送数据 通过Socket通信
* */
public class SendDemo {
    public static void main(String[] args) throws IOException {
        //创建发送端Socket对象
        DatagramSocket ds=new DatagramSocket();

        //创建数据 并把数据打包
        //创建数据
        byte[] bys="凌健爱徐小萌".getBytes();
        //长度
        int length=bys.length;
        //IP地址对象
        InetAddress address=InetAddress.getByName("192.168.0.133");
        //端口
        int port=10086;
        DatagramPacket dp=new DatagramPacket(bys,length,address,port);

        //调用Socket对象的发送方法发送数据包
        ds.send(dp);

        //释放资源
        ds.close();


    }
}
