package cn.lingjian_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author lingjian
 * @date 2019/10/10 - 3:00 下午
 */
public class GetName {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("name.txt"));
        ArrayList<String> list=new ArrayList<String>();
        String line=null;
        while((line=br.readLine())!=null){
            list.add(line);
        }
//        for (String s : list) {
//            System.out.println(s);
//        }
//        br.close();
//        Random r=new Random();
//        int index=r.nextInt(list.size());  //用该种方法

        int len=list.size();
        for (int i = 0; i <100 ; i++) {

            int index = (int) (Math.random() * len);
            System.out.println(list.get(index));
        }
    }
}
