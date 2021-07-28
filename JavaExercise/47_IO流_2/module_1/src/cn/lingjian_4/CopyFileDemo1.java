package cn.lingjian_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lingjian
 * @date 2019/9/30 - 9:13 上午
 */
/*
* 复制文件
*
* */
public class CopyFileDemo1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("demo2.txt");
        FileOutputStream fos=new FileOutputStream("copydemo2.txt");
        int by=0;
        while ((by=fis.read())!=-1){
            fos.write(by);
        }
        fis.close();
        fos.close();
    }
}
