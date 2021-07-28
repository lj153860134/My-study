package cn.lingjian_5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lingjian
 * @date 2019/10/28 - 3:50 下午
 */
public class ReceiveThred implements Runnable{

    private DatagramSocket ds;

    public ReceiveThred(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {

            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys, bys.length);
            while (true) {
                ds.receive(dp);
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = sdf.format(d);
                String ip = dp.getAddress().getHostAddress();
                String str = new String(dp.getData(), 0, dp.getLength());
                if (!str.equals("886")) {
                    System.out.println(ip + "," + time + ":" + str);
                } else {
                    System.out.println(ip + "," + time + ":" + str);
                    break;
                }

            }
            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
