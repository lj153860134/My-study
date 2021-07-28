package cn.lingjian_1;

import java.io.File;

/**
 * @author lingjian
 * @date 2019/9/26 - 8:38 下午
 */
/*
* 把桌面中的JavaExercise目录下所有的java后缀的文件的绝对路径输出在控制台
*
* */
public class DiGuiDemo3 {
    public static void main(String[] args) {
        //创建源文件夹的File类
        File srcFolder=new File("/Users/lingjian/Desktop/JavaExercise");
        getPath(srcFolder);
    }

    public static void getPath(File srcFolder) {
        File[] fileArray = srcFolder.listFiles();
        for (File file : fileArray) {
            if (file.isFile()) {
                if (file.getName().endsWith(".java")) {
                    System.out.println(file.getAbsolutePath());
                }

            }else{
                getPath(file);
            }

        }
    }
}
