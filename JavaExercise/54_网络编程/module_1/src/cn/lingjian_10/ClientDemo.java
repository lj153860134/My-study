package cn.lingjian_10;

import java.io.*;
import java.net.Socket;

/**
 * @author lingjian
 * @date 2019/10/29 - 2:28 下午
 */
/*
 * 客户端文件输入  服务器端文件输出
 * */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket s=new Socket("10.192.33.165",12468);
        BufferedReader br=new BufferedReader(new FileReader("lingjian_10_input.txt"));
        String line=null;

        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        while((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //自定义一个结束标记
//        bw.write("over");
//        bw.newLine();
//        bw.flush();

        //socket提供了一种终止功能 通知服务器没有数据过来了
        s.shutdownOutput();

        //得到反馈
        BufferedReader brClient=new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str=null;
        while((str=brClient.readLine())!=null){
            System.out.println(str);
        }

        br.close();
        s.close();
    }
}
