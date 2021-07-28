package cn.lingjian_6;

import java.io.*;
import java.util.Vector;

/**
 * @author lingjian
 * @date 2019/10/12 - 4:38 下午
 */
/*
* 多个文件合并流
* */
public class SequenceInputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        Vector<InputStream> v=new Vector<InputStream>();
        InputStream s1=new FileInputStream("b.txt");
        InputStream s2=new FileInputStream("c.txt");
        InputStream s3=new FileInputStream("d.txt");
        v.add(s1);
        v.add(s2);
        v.add(s3);
        SequenceInputStream sis=new SequenceInputStream(v.elements());
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("b_c_d_copy.txt"));

        int len=0;
        byte[] bys=new byte[1024];
        while((len=sis.read(bys))!=-1) {
            bos.write(bys, 0, len);
            bos.flush();
        }
        bos.close();
        sis.close();



    }
}
