package cn.lingjian_8;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author lingjian
 * @date 2019/10/11 - 10:07 上午
 */
public class MyBufferedReaderTest {
    public static void main(String[] args) throws IOException {
        MyBufferedReader mbr=new MyBufferedReader(new FileReader("mybufferedreader.txt"));
       String line=null;
       while((line=mbr.myReadLine())!=null){
           System.out.println(line);
       }
       mbr.close();

    }
}
