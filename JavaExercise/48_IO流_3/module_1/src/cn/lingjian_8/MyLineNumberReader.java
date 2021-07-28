package cn.lingjian_8;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author lingjian
 * @date 2019/10/11 - 11:02 上午
 */
public class MyLineNumberReader {
    private FileReader fr;
    private int lineNumber=0;


    public MyLineNumberReader(FileReader fr) {
        this.fr = fr;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String myReadLine()throws IOException {
        lineNumber++;
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
    public void close() throws IOException {
        this.fr.close();
    }
}
