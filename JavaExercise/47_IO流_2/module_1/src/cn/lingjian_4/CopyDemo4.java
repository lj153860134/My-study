package cn.lingjian_4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lingjian
 * @date 2019/10/9 - 10:06 上午
 */
public class CopyDemo4 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("/Users/lingjian/Desktop/25-203.jpg");
        FileOutputStream fos=new FileOutputStream("/Users/lingjian/Desktop/照片/本科一家人1.jpg");
        byte[] bys=new byte[1024];
        int len=0;
        while((len=fis.read(bys))!=-1){
            fos.write(bys,0,len);
        }
        fos.close();
        fis.close();


    }
}
