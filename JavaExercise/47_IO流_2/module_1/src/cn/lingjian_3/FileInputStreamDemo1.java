package cn.lingjian_3;

import javax.imageio.stream.FileCacheImageInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author lingjian
 * @date 2019/9/28 - 9:19 下午
 */
/*
* 一次读取一个字节
*
* */
public class FileInputStreamDemo1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("demo2.txt");
        int by=0;
        while((by=fis.read())!=-1){
            System.out.print((char) by);
        }
        fis.close();
    }
}
