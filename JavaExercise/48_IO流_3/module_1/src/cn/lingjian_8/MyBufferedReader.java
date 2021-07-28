package cn.lingjian_8;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author lingjian
 * @date 2019/10/11 - 9:49 上午
 */
/*
* 用Reader模拟BufferedReader的readLine（）功能
*
* */
public class MyBufferedReader {
    private FileReader fr;

    public MyBufferedReader(FileReader fr) {
        this.fr = fr;
    }

    public String myReadLine()throws IOException {
        int ch = 0;
        StringBuilder sb = new StringBuilder();
        while ((ch = fr.read()) != -1) {
            if (ch == '\n') {
                return sb.toString();
            } else {
                sb.append((char) ch);
            }
        }
        if(sb.length()>0)
            return sb.toString();
        return null;
    }

    //写一个关闭方法
    public void close() throws IOException{
        this.fr.close();
    }
}
