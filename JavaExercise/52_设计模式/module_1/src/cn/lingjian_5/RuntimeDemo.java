package cn.lingjian_5;

import java.io.IOException;

/**
 * @author lingjian
 * @date 2019/10/23 - 10:55 上午
 */
public class RuntimeDemo {
    public static void main(String[] args) throws IOException {
        Runtime r=Runtime.getRuntime();
        r.exec("ls/Desktop");
    }
}
