package cn.lingjian_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lingjian
 * @date 2019/9/28 - 11:33 上午
 */
/*
 *  往一个文本中输入一句话：hello,io.
 *
 * */
public class FileOutputStreamDemo1 {
    public static void main(String[] args) throws IOException {
//        File file=new File("/Users/lingjian/Desktop/demo.txt");
//        FileOutputStream fos=new FileOutputStream(file);

        //另一种写法
        FileOutputStream fos = new FileOutputStream("/Users/lingjian/Desktop/demo.txt");
        fos.write("Hello,IO".getBytes());
        fos.close();

    }

}
