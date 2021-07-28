package cn.lingjian_8;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lingjian
 * @date 2019/10/29 - 10:17 上午
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(10087);
        Socket s=ss.accept();

        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line =null;
        BufferedWriter bw=new BufferedWriter(new FileWriter("lingjian_8.txt"));

        while((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close(); //bw要关闭 遇到文件操作流
        s.close();

    }
}
