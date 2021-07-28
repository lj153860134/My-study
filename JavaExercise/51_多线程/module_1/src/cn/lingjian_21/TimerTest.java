package cn.lingjian_21;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;



/**
 * @author lingjian
 * @date 2019/10/22 - 8:54 下午
 */
/*
* 需求：在指定的时间删除指定的目录
*
* */

class DeleteFolder extends TimerTask {
    @Override
    public void run() {
        File srcFolder=new File("/Users/lingjian/Desktop/test1");
        deleteFolder(srcFolder);

    }

    //递归删除目录
    public void deleteFolder(File srcFolder){
        File[] fileArray=srcFolder.listFiles();
        if(fileArray!=null){
            for (File file : fileArray) {
                if(file.isDirectory()){
                    deleteFolder(file);
                }else{
                    file.delete();
                }

            }
            srcFolder.delete();
        }
    }
}
public class TimerTest {
    public static void main(String[] args) throws ParseException {
        Timer t=new Timer();
        String s="2019-10-22 21:15:30";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d=sdf.parse(s);

        t.schedule(new DeleteFolder(),d);
    }

}
