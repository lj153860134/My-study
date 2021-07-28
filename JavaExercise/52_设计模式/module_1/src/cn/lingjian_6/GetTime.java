package cn.lingjian_6;

import java.io.*;

/**
 * @author lingjian
 * @date 2019/11/1 - 10:45 上午
 */
/*
* 计算出一段代码的运行时间
* */
public class GetTime {
   public long getTime()throws IOException {
       long start=System.currentTimeMillis();

       //for循环耗时
//       for (int i = 0; i < 10000; i++) {
//           System.out.println(i);
//       }

       //复制视频的时间
       BufferedInputStream bis=new BufferedInputStream(new FileInputStream("1.avi"));
       BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("2.avi"));
       byte[] bys=new byte[1024];
       int len=0;
       while((len=bis.read(bys))!=-1){
           bos.write(bys,0,len);
       }
       bos.close();
       bis.close();

       long end =System.currentTimeMillis();
       return end-start;
   }
}
