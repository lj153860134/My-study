package cn.lingjian_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lingjian
 * @date 2019/10/11 - 8:51 下午
 */
public class SystemInDemo1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符串");
        String s=br.readLine();
        System.out.println("字符串为: "+s);
        System.out.println("请输入一个整数");
        int x=Integer.parseInt(br.readLine());
        System.out.println("整数为: "+x);
    }

}
