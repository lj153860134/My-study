package cn.lingjian_2;

import java.io.*;

/**
 * @author lingjian
 * @date 2019/10/10 - 9:28 上午
 */
public class CopyDemo3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("b2.txt"));
        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line); //不包括换行符 所以一定要在后面加上newLine()
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();

    }
}
