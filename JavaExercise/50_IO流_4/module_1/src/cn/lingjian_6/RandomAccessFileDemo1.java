package cn.lingjian_6;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author lingjian
 * @date 2019/10/12 - 3:43 下午
 */
public class RandomAccessFileDemo1 {
    public static void main(String[] args) throws IOException {
        write();
        read();
    }



    private static void write() throws IOException{
        RandomAccessFile raf=new RandomAccessFile("raf.txt","rw");
        //写入数据
        raf.writeInt(100);
        raf.writeChar('a');
        raf.writeUTF("中国");


        raf.close();
    }


    private static void read() throws IOException{
        RandomAccessFile raf=new RandomAccessFile("raf.txt","rw");
        int i=raf.readInt();
        System.out.println(i);
        System.out.println(raf.getFilePointer());

        char ch=raf.readChar();
        System.out.println(ch);
        System.out.println(raf.getFilePointer());

        String s=raf.readUTF();
        System.out.println(s);
        System.out.println(raf.getFilePointer());

    }




}
