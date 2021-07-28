package cn.lingjian_5;

import java.io.*;

/**
 * @author lingjian
 * @date 2019/10/11 - 9:31 下午
 */
public class SystemOutDemo1 {
    public static void main(String[] args) throws IOException {
//        PrintStream ps=System.out;
//        OutputStream os=System.out;  多态
//        OutputStreamWriter osw=new OutputStreamWriter(os);
//        BufferedWriter bw=new BufferedWriter(osw);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("hello");
        bw.newLine();
        bw.write("world");
        bw.newLine();
        bw.write("java");
        bw.newLine();
        bw.flush();
        bw.close();



    }
}
