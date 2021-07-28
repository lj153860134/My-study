package cn.lingjian_6;

import java.io.*;

/**
 * @author lingjian
 * @date 2019/10/12 - 4:21 下午
 */
/*
* 两个文件合并
* */
public class SequenceInputStreamDemo1 {
    public static void main(String[] args) throws IOException {
        InputStream is1=new FileInputStream("b.txt");
        InputStream is2=new FileInputStream("c.txt");
        SequenceInputStream sis=new SequenceInputStream(is1,is2);
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("b_c_copy.txt"));

        //按照以前的读写方法
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
