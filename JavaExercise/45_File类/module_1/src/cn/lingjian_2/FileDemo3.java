package cn.lingjian_2;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author lingjian
 * @date 2019/9/26 - 11:00 上午
 */
/*
*  判断目录下是否有后缀为.doc的文件
* （要首先判断是否是文件 再判断后缀是否为.doc）
*  如果有就输出文件名称
*
*
*
* */
public class FileDemo3 {
    public static void main(String[] args) {
        File file=new File("/Users/lingjian/Desktop");
        //方法一：先获取所有的 然后遍历 依次判断是否是文件 后缀 满足条件输出
        File[] fileArray=file.listFiles();
        for (File f : fileArray) {
            if(f.isFile())
                if(f.getName().endsWith(".doc"))
                    System.out.println(f.getName());

        }
        System.out.println("------------");
        //方法二：获取的时候已经满足条件 输出即可
        String[] fileArrays=file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
              return new File(dir,name).isFile()&&name.endsWith(".doc");
            }
        });

        for (String s : fileArrays) {
            System.out.println(s);
        }

        //方法三 类似方法二
        File[] fielArrays=file.listFiles(new FilenameFilter(){

            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isFile()&&name.endsWith(".doc");
            }
        });
        System.out.println("------------");
        for (File f : fielArrays) {
            System.out.println(f.getName());

        }
    }
}
