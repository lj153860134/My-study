package cn.lingjian_2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lingjian
 * @date 2019/10/9 - 9:21 下午
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("a.txt");
        FileWriter fw=new FileWriter("b1.txt");
        int len=0;
        char[] chs=new char[1024];
        while((len=fr.read(chs))!=-1) {
            fw.write(new String(chs,0,len));
            fw.flush();
        }
        fw.close();
        fr.close();
    }
}
