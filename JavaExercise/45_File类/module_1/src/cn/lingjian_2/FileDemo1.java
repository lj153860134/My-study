package cn.lingjian_2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lingjian
 * @date 2019/9/26 - 10:26 上午
 */
public class FileDemo1 {
    public static void main(String[] args) {
        File file=new File("demo/test.txt");
        System.out.println(file.isFile());

        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.length());
        System.out.println(file.lastModified());  //1569465124512

        Date d=new Date(1569465886953L);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(d));
    }
}
