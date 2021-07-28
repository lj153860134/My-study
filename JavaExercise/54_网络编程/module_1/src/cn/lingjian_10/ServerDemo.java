package cn.lingjian_10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lingjian
 * @date 2019/10/29 - 2:28 下午
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(12468);
        Socket s=ss.accept();

        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line=null;

        BufferedWriter bw=new BufferedWriter(new FileWriter("lingjian_10_output.txt"));

        while((line=br.readLine())!=null){ //这里会出现问题 要加一个判断
//            if(line.equals("over"))
//                break;
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //给出反馈
        BufferedWriter bwServer=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bwServer.write("你们真的很相爱哦 好羡慕凌健和徐小萌 ");
        bwServer.newLine();
        bwServer.flush();

        bw.close();
        s.close();
    }
}
