package cn.lingjian_3;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lingjian
 * @date 2019/10/11 - 8:09 下午
 */
/*
* 打印流
* */
public class PrintWriterDemo1 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw=new PrintWriter("pw.txt");
        pw.write("hello");
        pw.write("world");
        pw.write("java");
        pw.close();

    }
}
