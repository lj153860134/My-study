package cn.lingjian_7;

import java.io.*;
import java.util.TreeSet;

/**
 * @author lingjian
 * @date 2019/10/10 - 10:16 下午
 */
public class StringDemo {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("s.txt"));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("ss.txt"));
        TreeSet<Character> ts=new TreeSet<Character>();
        int ch=0;
        while((ch=bis.read())!=-1){
            ts.add((char)ch);
        }
        for (Character t : ts) {
            bos.write(t);
        }
        bos.close();
        bis.close();
    }
}
