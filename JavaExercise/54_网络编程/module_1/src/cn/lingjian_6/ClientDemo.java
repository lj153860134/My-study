package cn.lingjian_6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author lingjian
 * @date 2019/10/28 - 4:18 下午
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //创建发送端的Socket对象
        Socket s=new Socket("10.192.50.7",12121);

        //获取输出流 写数据
        OutputStream os=s.getOutputStream();
        os.write("凌健爱徐小萌".getBytes());

        //获取服务器端的反馈
        InputStream is=s.getInputStream();
        byte[] bys=new byte[1024];
        int len=is.read(bys);  //阻塞式方法
        String str=new String(bys,0,len);
        System.out.println(str);

        s.close();
    }
}
