package cn.lingjian_4;

import java.io.*;

/**
 * @author lingjian
 * @date 2019/10/10 - 10:15 上午
 */
/*
 * 用字符流5种方式 复制文件 推荐使用第5种
 *
 * */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        method1("数据源/a1.txt", "目的源/b1.txt");
        method2("数据源/a2.txt", "目的源/b2.txt");
        method3("数据源/a3.txt", "目的源/b3.txt");
        method4("数据源/a4.txt", "目的源/b4.txt");
        method5("数据源/a5.txt", "目的源/b5.txt");
    }

    private static void method1(String s1, String s2) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(s1));
        OutputStreamWriter osw = new OutputStreamWriter((new FileOutputStream(s2)));
        int ch = 0;
        while ((ch = isr.read()) != -1)
            osw.write(ch);
        osw.close();
        isr.close();
    }

    private static void method2(String s1, String s2) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(s1));
        OutputStreamWriter osw = new OutputStreamWriter((new FileOutputStream(s2)));
        int len = 0;
        char[] chs = new char[1024];
        while ((len = isr.read(chs)) != -1) {
            osw.write(chs, 0, len);
            osw.flush();
        }
        osw.close();
        isr.close();


    }

    private static void method3(String s1, String s2) throws IOException {
        FileReader fr = new FileReader(s1);
        FileWriter fw = new FileWriter(s2);
        int ch = 0;
        while ((ch = fr.read()) != -1)
            fw.write(ch);
        fr.close();
        fw.close();
    }

    private static void method4(String s1, String s2) throws IOException {
        FileReader fr = new FileReader(s1);
        FileWriter fw = new FileWriter(s2);
        int len = 0;
        char[] chs = new char[1024];
        while ((len = fr.read(chs)) != -1) {
            fw.write(chs, 0, len);
            fw.flush();
        }
        fr.close();
        fw.close();
    }

    private static void method5(String s1, String s2) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(s1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(s2));
        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }


}
