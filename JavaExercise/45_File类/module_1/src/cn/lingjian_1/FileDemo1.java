package cn.lingjian_1;

import java.io.File;
import java.io.IOException;

/**
 * @author lingjian
 * @date 2019/9/25 - 9:01 下午
 */
/*
 *
 * File类的创建功能
 * */
public class FileDemo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/lingjian/Desktop/demo");
        System.out.println(file.mkdir());
        File file2 = new File("/Users/lingjian/Desktop/demo/a.txt");
        System.out.println(file2.createNewFile());
        File file3 = new File("/Users/lingjian/Desktop/demo2/aaa/bbb");
        System.out.println(file3.mkdirs());

        File file4 = new File("a.txt");
        file4.createNewFile();

        File file5=new File("a.txt");
        file4.delete();   //删除功能

        File file6 = new File("b.txt");
        System.out.println(file6.getAbsolutePath());
        System.out.println(file6.getPath());
//        System.out.println(file4.renameTo(file6));  //重命名功能
        System.out.println("--------");
        //判断功能
        System.out.println(file6.isDirectory());
        System.out.println(file6.isFile());
        System.out.println(file6.exists());
        System.out.println(file6.canRead());
        System.out.println(file6.canWrite());
        System.out.println(file6.isHidden());


    }
}
