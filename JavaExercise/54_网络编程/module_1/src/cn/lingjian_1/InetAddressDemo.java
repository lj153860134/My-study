package cn.lingjian_1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author lingjian
 * @date 2019/10/25 - 11:00 上午
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address=InetAddress.getByName("lingjiandeMacBook-Pro-2.local");
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());
    }
}
