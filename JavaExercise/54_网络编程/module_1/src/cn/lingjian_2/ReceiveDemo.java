package cn.lingjian_2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author lingjian
 * @date 2019/10/25 - 2:47 下午
 */
/*
 * UDP协议接受数据 通过Socket通信
 * */
public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        //创建发送端Socket对象
        DatagramSocket ds=new DatagramSocket(10086);


        //创建一个数据包(接收容器)
        byte[] bys=new byte[1024];
        int length=bys.length;
        DatagramPacket dp=new DatagramPacket(bys,length);

        //调用Socket对象的接收方法接收数据
        ds.receive(dp);//阻塞式

        //获取对方的IP
        InetAddress address=dp.getAddress();
        System.out.println(address);
        String ip=address.getHostAddress();
        System.out.println(ip);

        //解析数据包 数据显示在控制台上
        byte[] bys2=dp.getData();
        int len=dp.getLength();
        String str=new String(bys2,0,len);
        System.out.println(ip+":"+str);

        //释放资源
        ds.close();
    }
}
