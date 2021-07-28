package cn.lingjian_5;

import java.io.*;

/**
 * @author lingjian
 * @date 2019/10/10 - 4:00 下午
 */
/*
 * 复制指定目录下的指定文件，并修改后缀名
 * */
public class CopyFolderDemo2 {
    public static void main(String[] args) throws IOException{
        File srcFoleder=new File("数据源");
        File destFolder=new File("/Users/lingjian/Desktop/jad");
        if(!destFolder.exists()){
            destFolder.mkdir();
        }
        //获取该目录下 后缀名为.txt文件的File数组
        File[] fileArray= srcFoleder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isFile()&&name.endsWith(".txt");
            }
        });

        for (File file : fileArray) {
            String name=file.getName();
            File newFile=new File(destFolder,name);
            copyFile(file,newFile);

        }
        //在目的地目录下改名
        File[] destFileArray=destFolder.listFiles();
        for (File file : destFileArray) {
            String name=file.getName();
            String newName=name.replace(".txt",".jad");
            File newFile=new File(destFolder,newName);
            file.renameTo(newFile);
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
