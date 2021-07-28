package cn.lingjian_5;

import java.io.*;

/**
 * @author lingjian
 * @date 2019/10/10 - 4:39 下午
 */
/*
 * 复制多级文件夹
 * */
public class CopyFolderDemo3 {
    public static void main(String[] args) throws IOException {
        //封装数据源File
        File srcFolder = new File("/Users/lingjian/Desktop/大学毕业照片");
        //封装目的地File
        File destFolder = new File("/Users/lingjian/Desktop/test1");
        //复制文件夹的功能
        if (!destFolder.isFile())
            destFolder.mkdir();
        copyFolder(srcFolder, destFolder);


    }


    private static void copyFolder(File srcFolder, File destFolder) throws IOException{
        //判断File是文件夹还是文件
        if (srcFolder.isDirectory()) {
            File newFolder=new File(destFolder,srcFolder.getName());
            newFolder.mkdir();
            File[] fileArray= srcFolder.listFiles();
            for (File file : fileArray) {
                copyFolder(file,newFolder);

            }

        }else{
            File newFile=new File(destFolder,srcFolder.getName());
            copyFile(srcFolder,newFile);
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
