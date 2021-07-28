package cn.lingjian_9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author lingjian
 * @date 2019/10/16 - 9:44 上午
 */
public class NIODemo1 {
    public static void main(String[] args) throws IOException {
        Files.copy(Paths.get("b.txt"),new FileOutputStream("b_copy.java"));
        ArrayList<String> list=new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("java");
        Files.write(Paths.get("list.txt"),list, Charset.forName("GBK"));
    }
}
