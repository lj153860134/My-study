package cn.lingjian_5;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lingjian
 * @date 2019/10/9 - 10:19 上午
 */
public class BufferedOutputStreamDemo1 {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("fos.txt"));
        bos.write("hello".getBytes());
        bos.close();
    }
}
