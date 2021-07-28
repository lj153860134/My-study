package cn.lingjian_1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author lingjian
 * @date 2019/10/9 - 8:38 下午
 */
public class OutputStreamWriterDemo2 {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw =new OutputStreamWriter(new FileOutputStream("osw1.txt"));
        char[] chs=new char[]{97,98,'c'};
        osw.write(chs);
        osw.write('a');
        osw.write(97);
        osw.write("\r\n凌健");
        osw.flush();
        osw.close();
    }
}
