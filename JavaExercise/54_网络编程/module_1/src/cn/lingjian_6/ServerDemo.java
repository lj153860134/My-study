package cn.lingjian_6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lingjian
 * @date 2019/10/28 - 4:39 下午
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //创建接收端Socket对象
        ServerSocket ss=new ServerSocket(12121);

        //监听客户端连接 返回一个对应的Socket对象
        Socket s=ss.accept();   //阻塞式方法
        InputStream is=s.getInputStream();

        byte[] bys=new byte[1024];
        int len=is.read(bys);  //阻塞式方法
        String str=new String(bys,0,len);

        //获取Ip地址
        String ip=s.getInetAddress().getHostAddress();

        System.out.println(ip+":"+str);

        //反馈数据
        OutputStream os=s.getOutputStream();
        os.write("徐小萌也爱凌健哦".getBytes());

        //释放资源
        s.close();
//        ss.close();  //这个不应该关闭 是服务器端

    }
}
