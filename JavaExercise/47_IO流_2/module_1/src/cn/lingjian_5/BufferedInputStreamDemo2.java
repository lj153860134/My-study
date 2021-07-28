package cn.lingjian_5;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author lingjian
 * @date 2019/10/9 - 10:53 上午
 */
public class BufferedInputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("fos.txt"));
        byte[] bys=new byte[1024];
        int len=0;
        while((len=bis.read(bys))!=-1)
            System.out.print(new String(bys,0,len));
        bis.close();
    }

}
