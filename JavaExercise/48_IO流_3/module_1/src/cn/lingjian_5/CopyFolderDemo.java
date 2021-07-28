package cn.lingjian_5;

import java.io.*;

/**
 * @author lingjian
 * @date 2019/10/10 - 3:20 下午
 */
/*
* 复制单极文件
* */
public class CopyFolderDemo {
    public static void main(String[] args) throws IOException{
        //封装目录
        File srcFolder=new File("数据源");
        //封装目的地
        File destFolder=new File("/Users/lingjian/Desktop/test");
        //如果目的地文件夹不存在，就创建
        if(!destFolder.exists())
            destFolder.mkdir();
        //获取该目录下的所有文本的File数组
        File[] fileArray=srcFolder.listFiles();
        //遍历该File数组，得到每一个File对象
        for(File file:fileArray){
            String name=file.getName();
            File newFile=new File(destFolder,name);
            copyFile(file,newFile);
        }

    }

    private static void copyFile(File file, File newFile) throws IOException {
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(newFile));
        int len=0;
        byte[] bys=new byte[1024];
        while((len=bis.read(bys))!=-1){
            bos.write(bys,0,len);
            bos.flush();
        }
        bos.close();
        bis.close();
    }
}
