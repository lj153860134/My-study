package cn.lingjian_3;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lingjian
 * @date 2019/10/11 - 8:13 下午
 */
public class PrintWriterDemo2 {
    public static void main(String[] args) throws IOException {
//        PrintWriter pw=new PrintWriter("pw2.txt");
        PrintWriter pw=new PrintWriter(new FileWriter("pw2.txt"),true);
        pw.println(true);
        pw.println(100);
        pw.println("hello");

        pw.close();
    }
}
