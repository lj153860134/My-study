package cn.lingjian_2;

import java.io.*;

/**
 * @author lingjian
 * @date 2019/10/9 - 9:06 下午
 */
public class CopyDemo1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(new FileInputStream("a.txt"));
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("b.txt"));
        int ch=0;
        while((ch=isr.read())!=-1)
            osw.write(ch);
        osw.close();
        isr.close();
    }
}
