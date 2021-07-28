package cn.lingjian_12;

import java.io.*;
import java.net.Socket;

/**
 * @author lingjian
 * @date 2019/10/29 - 3:14 下午
 */
/*
* TCP协议上传图片并给出反馈
* */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket s=new Socket("10.192.33.165",11111);
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("25-203.jpg"));
        BufferedOutputStream bos=new BufferedOutputStream(s.getOutputStream());

        byte[] bys=new byte[1024];
        int len=0;
        while((len=bis.read(bys))!=-1){
            bos.write(bys,0,len);
            bos.flush();
        }

        //给出终止
        s.shutdownOutput();

        //获取反馈
        InputStream is=s.getInputStream();
        byte[] bys2=new byte[1024];
        int len2=is.read(bys2);
        String str=new String(bys2,0,len2);
        System.out.println(str);

        bis.close();
        s.close();
    }
}
