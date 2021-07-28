package cn.lingjian_2;

import java.io.File;

/**
 * @author lingjian
 * @date 2019/9/26 - 10:49 上午
 */
public class FileDemo2 {
    public static void main(String[] args) {
        File file=new File("/Users/lingjian/Desktop");
        String[] strArray=file.list();
        for (String s : strArray) {
            System.out.println(s);
        }
        System.out.println("----------");
        File[] fielArray=file.listFiles();
        for (File file1 : fielArray) {
            System.out.println(file1.getName());

        }

    }
}
