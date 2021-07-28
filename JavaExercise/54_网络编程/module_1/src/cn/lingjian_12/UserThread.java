package cn.lingjian_12;

import java.io.*;
import java.net.Socket;

/**
 * @author lingjian
 * @date 2019/10/29 - 3:59 下午
 */
public class UserThread implements Runnable {
    private Socket s;

    public UserThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            //分装通道内流
            BufferedInputStream bis = new BufferedInputStream(s.getInputStream());

            //分装图片文件
//            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("本科一家人.jpg"));
            //为了防止名称冲突
            String newName=System.currentTimeMillis()+".jpg";
            BufferedOutputStream bos=new BufferedOutputStream((new FileOutputStream(newName)));
            byte[] bys = new byte[1024];
            int len = 0;
            while ((len = bis.read(bys)) != -1) {
                bos.write(bys, 0, len);
                bos.flush();
            }


            //给出反馈
            OutputStream os = s.getOutputStream();
            os.write("图片上传成功".getBytes());

            //释放资源
            bos.close();
            s.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
