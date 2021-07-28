package cn.lingjian_5;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lingjian
 * @date 2019/10/9 - 10:46 上午
 */
/*
* 一次读取一个字节
* */
public class BufferedInputStreamDemo1 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("fos.txt"));
        int by=0;
        while((by=bis.read())!=-1)
            System.out.print((char) by);
        bis.close();
    }
}
