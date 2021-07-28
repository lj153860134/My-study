package cn.lingjian_4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lingjian
 * @date 2019/9/30 - 10:31 上午
 */
/*
*
* */
public class CopyFileDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("/Users/lingjian/Desktop/25-203.jpg");
        FileOutputStream fos=new FileOutputStream("/Users/lingjian/Desktop/照片/本科一家人.jpg");
        int by=0;
        while((by=fis.read())!=-1)
            fos.write(by);
        fis.close();
        fos.close();


    }
}
