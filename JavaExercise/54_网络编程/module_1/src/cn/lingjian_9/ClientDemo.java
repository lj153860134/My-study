package cn.lingjian_9;

import java.io.*;
import java.net.Socket;
import java.sql.BatchUpdateException;

/**
 * @author lingjian
 * @date 2019/10/29 - 10:41 上午
 */
/*
* 客户端文件输入  服务器端显示在控制台上
* */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket s=new Socket("10.192.33.165",12345);

        BufferedReader br=new BufferedReader(new FileReader("lingjian_9.txt"));
        String line= null;
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        while ((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        br.close();
        s.close();

    }
}
