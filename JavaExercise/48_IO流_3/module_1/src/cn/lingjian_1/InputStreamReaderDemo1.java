package cn.lingjian_1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lingjian
 * @date 2019/10/9 - 8:14 下午
 */
public class InputStreamReaderDemo1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(new FileInputStream("isr.txt"));
        int ch=0;
        while((ch=isr.read())!=-1)
            System.out.print((char)ch);
//        int len=0;
//        char[] chs=new char[1024];
//        while((len=isr.read(chs))!=-1)
//            System.out.print(new String(chs,0,len));
        isr.close();
    }

}
