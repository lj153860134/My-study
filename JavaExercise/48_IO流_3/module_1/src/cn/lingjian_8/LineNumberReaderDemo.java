package cn.lingjian_8;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * @author lingjian
 * @date 2019/10/11 - 11:00 上午
 */
public class LineNumberReaderDemo {
    public static void main(String[] args) throws IOException {
        LineNumberReader lnr=new LineNumberReader(new FileReader("mybufferedreader.txt"));
        String line=null;
        lnr.setLineNumber(20);
        while((line=lnr.readLine())!=null){
            System.out.println(lnr.getLineNumber()+":"+line);
        }
        lnr.close();

    }
}
