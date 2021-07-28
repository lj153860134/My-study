package cn.lingjian_2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lingjian
 * @date 2019/9/28 - 8:51 下午
 */
public class FileOutputStreamDemo1 {
    public static void main(String[] args) {
//        FileOutputStream fos= null;
//        try {
//            fos = new FileOutputStream("demo1.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            fos.write("java".getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //可读性更好 且保证close()一定会执行
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("demo1.txt");
            fos.write("java1".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
