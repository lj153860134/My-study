package cn.lingjian_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lingjian
 * @date 2019/10/29 - 9:27 上午
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);

        Socket s = ss.accept();
        //客户端包装成字符流  服务器端也要改成字符流
//        InputStream is = s.getInputStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str=null;

        while ((str=br.readLine())!=null) {
//            byte[] bys = new byte[1024];
//            int len = is.read(bys);
//            String str = new String(bys, 0, len);

//            if (!str.equals("886")) {
//                System.out.println(str);
//            } else {
//                System.out.println(str);
//                break;
//            }
            System.out.println(str);
        }
//        br.close(); // s关闭 br就关闭了
        s.close();
//        ss.close();  //服务器不关
    }
}
