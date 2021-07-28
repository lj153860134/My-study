package cn.lingjian_4;

import java.util.Arrays;

/**
 * @author lingjian
 * @date 2019/9/30 - 10:22 上午
 */
public class StringDemo {
    public static void main(String[] args) {
        String s="abcde";
       byte[] bys=s.getBytes();
        System.out.println(Arrays.toString(bys));
    }
}
