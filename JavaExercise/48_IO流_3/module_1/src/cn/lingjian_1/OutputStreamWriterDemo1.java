package cn.lingjian_1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author lingjian
 * @date 2019/10/9 - 8:02 下午
 */
public class OutputStreamWriterDemo1 {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("osw.txt"));
        osw.write("凌健");
        osw.close();
    }
}
