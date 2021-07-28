package cn.lingjian_8;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * @author lingjian
 * @date 2019/10/11 - 11:08 上午
 */
public class MyLineNumberReaderTest {
    public static void main(String[] args) throws IOException {
        MyLineNumberReader mlnr=new  MyLineNumberReader(new FileReader("mybufferedreader.txt"));
        String line=null;
        mlnr.setLineNumber(10);
        while((line=mlnr.myReadLine())!=null){
            System.out.println(mlnr.getLineNumber()+":"+line);
        }
        mlnr.close();

    }
}
