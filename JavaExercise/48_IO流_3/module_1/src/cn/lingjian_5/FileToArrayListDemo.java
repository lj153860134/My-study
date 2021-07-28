package cn.lingjian_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author lingjian
 * @date 2019/10/10 - 2:55 下午
 */
public class FileToArrayListDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("arraylist.txt"));
        ArrayList<String> list=new ArrayList<String>();
        String line=null;
        while((line=br.readLine())!=null){
            list.add(line);
        }
        for (String s : list) {
            System.out.println(s);
        }
        br.close();
    }
}
