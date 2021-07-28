package cn.lingjian_5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author lingjian
 * @date 2019/10/10 - 2:45 下午
 */
public class ArrayListToFileDemo {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list=new ArrayList<String>();
        BufferedWriter bw=new BufferedWriter(new FileWriter("arraylist.txt"));
        list.add("凌健");
        list.add("爱");
        list.add("徐小萌");
        for (String s : list) {
            bw.write(s);
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
