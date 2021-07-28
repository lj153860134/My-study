package cn.lingjian_3;

import java.io.*;

/**
 * @author lingjian
 * @date 2019/10/9 - 9:43 下午
 */
/*
* 字符缓冲流的特殊方法
* */
public class BUfferedDemo {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter("bw.txt"));
        BufferedReader br=new BufferedReader(new FileReader("bw.txt"));
        for (int i = 0; i <10 ; i++) {
            bw.write("hello"+i);
            bw.newLine();
            bw.flush();
        }
        bw.close();

        String line=null;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();


    }
}
