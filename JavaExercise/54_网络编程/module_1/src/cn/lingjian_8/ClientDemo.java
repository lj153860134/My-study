package cn.lingjian_8;

import java.io.*;
import java.net.Socket;

/**
 * @author lingjian
 * @date 2019/10/29 - 9:27 上午
 */
/*
* 需求：客户端键盘录入 服务器输出到文件上
*
* */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
//        Scanner sc=new Scanner(System.in);
        Socket s=new Socket("10.192.50.7",10087);

        //键盘录入数据的高效方法
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        //把通道内的流包装一下
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String str=null;
        while ((str=br.readLine())!=null){
//            System.out.println("Please enter your message");
//            String str=sc.nextLine();
            if(!str.equals("886")) {
                bw.write(str);
                bw.newLine();
                bw.flush();
            }else{
                bw.write(str);
                bw.newLine();
                bw.flush();
                break;
            }
        }
//        bw.close();   //s 关闭 bw就会自动关闭
//        br.close();   //当输入886 键盘录入就不存在了 br不需要关闭
        s.close();
    }
}
