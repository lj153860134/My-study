package cn.lingjian_3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author lingjian
 * @date 2019/9/30 - 10:43 上午
 */
/*
* 一次读取一个字节数组
* */
public class FileInputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("demo3.txt");
//        byte[] bys=new byte[5];
//        int length=fis.read(bys);
//        System.out.print(new String(bys,0,length));
//
//         length=fis.read(bys);
//        System.out.print(new String(bys,0,length));
//
//         length=fis.read(bys);
//        System.out.print(new String(bys,0,length));
//
//        length=fis.read(bys);
//        System.out.print(new String(bys,0,length));
//        System.out.println("----------");

        //标准写法
        byte[] by=new byte[1024];
        int len=0;
        while((len=fis.read(by))!=-1)
            System.out.print(new String(by,0,len));
    }
}
