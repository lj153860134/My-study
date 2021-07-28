package cn.lingjian_1;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lingjian
 * @date 2019/9/28 - 12:28 下午
 */
/*
* 实现数据换行
* 实现数据的追加写入
*
* */
public class FileOutputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos =new FileOutputStream("demo.txt",true);

        for (int i = 0; i <10 ; i++) {
            fos.write(("HelloWorld "+i+"\r").getBytes());
            
        }

        fos.close();

    }

}
