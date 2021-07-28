package cn.lingjian_12;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lingjian
 * @date 2019/10/29 - 4:02 下午
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(11111);
        while (true) {
            Socket s = ss.accept();
            Thread t=new Thread(new UserThread(s));
            t.start();

        }
    }
}
