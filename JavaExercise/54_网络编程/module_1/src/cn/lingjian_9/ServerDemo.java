package cn.lingjian_9;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lingjian
 * @date 2019/10/29 - 10:41 上午
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(12345);

        Socket s=ss.accept();

        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line=null;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }

        s.close();



    }

}
