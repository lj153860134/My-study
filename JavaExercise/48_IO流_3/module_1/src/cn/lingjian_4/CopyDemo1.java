package cn.lingjian_4;

import java.io.*;

/**
 * @author lingjian
 * @date 2019/10/10 - 10:38 上午
 */
/*
*   用字节流的4种方法复制图片
*
* */
public class CopyDemo1 {
    public static void main(String[] args) throws IOException{
        method1("/Users/lingjian/Desktop/25-203.jpg","/Users/lingjian/Desktop/照片/25-203-1.jpg");
        method2("/Users/lingjian/Desktop/25-203.jpg","/Users/lingjian/Desktop/照片/25-203-2.jpg");
        method3("/Users/lingjian/Desktop/25-203.jpg","/Users/lingjian/Desktop/照片/25-203-3.jpg");
        method4("/Users/lingjian/Desktop/25-203.jpg","/Users/lingjian/Desktop/照片/25-203-4.jpg");
    }

    private static void method1(String s1, String s2) throws IOException {
        FileInputStream fis=new FileInputStream(s1);
        FileOutputStream fos=new FileOutputStream(s2);
        int ch=0;
        while ((ch=fis.read())!=-1)
            fos.write( ch);
        fos.close();
        fis.close();
    }

    private static void method2(String s1, String s2) throws IOException {
        FileInputStream fis=new FileInputStream(s1);
        FileOutputStream fos=new FileOutputStream(s2);
        int len=0;
        byte[] bys=new byte[1024];
        while ((len=fis.read(bys))!=-1){
            fos.write(bys,0,len);
            fos.flush();
        }
        fos.close();
        fis.close();
    }

    private static void method3(String s1, String s2) throws IOException {
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(s1));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(s2));
        int ch=0;
        while ((ch=bis.read())!=-1)
            bos.write( ch);
        bos.close();
        bis.close();
    }

    private static void method4(String s1, String s2) throws IOException {
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(s1));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(s2));
        int len=0;
        byte[] bys=new byte[1024];
        while ((len=bis.read(bys))!=-1){
            bos.write(bys,0,len);
            bos.flush();
        }
        bos.close();
        bis.close();
    }
}
