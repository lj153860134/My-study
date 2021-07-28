package cn.lingjian_11;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lingjian
 * @date 2019/10/29 - 3:14 下午
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(8888);

        //监听客户端连接
        Socket s=ss.accept();

        //分装通道内流
        BufferedInputStream bis=new BufferedInputStream(s.getInputStream());

        //分装图片文件
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("本科一家人.jpg"));

        byte[] bys=new byte[1024];
        int len=0;
        while((len=bis.read(bys))!=-1){
            bos.write(bys,0,len);
            bos.flush();
        }


        //给出反馈
        OutputStream os=s.getOutputStream();
        os.write("图片上传成功".getBytes());

        //释放资源
        bos.close();
        s.close();

    }
}
