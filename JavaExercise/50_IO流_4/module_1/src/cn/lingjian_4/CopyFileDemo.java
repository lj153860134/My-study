package cn.lingjian_4;

import java.io.*;

/**
 * @author lingjian
 * @date 2019/10/11 - 8:36 下午
 */
public class CopyFileDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("srccopy.txt"));
        PrintWriter pw=new PrintWriter(new FileWriter("destcopy.txt"),true);
        String line=null;
        while((line=br.readLine())!=null)
            pw.println(line);
        pw.close();
        br.close();
    }

}
