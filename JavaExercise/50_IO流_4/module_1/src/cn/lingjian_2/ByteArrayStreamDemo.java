package cn.lingjian_2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author lingjian
 * @date 2019/10/11 - 7:36 下午
 */
/*
* 内存操作流
*
* */
public class ByteArrayStreamDemo {
    public static void main(String[] args) throws IOException {
        //写数据
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        for (int i = 0; i < 10; i++) {
            baos.write(("hello"+i).getBytes());
        }
        //释放资源 什么都能没做 根本不需要close()
//        baos.close();

        ByteArrayInputStream bais=new ByteArrayInputStream(baos.toByteArray());
        int ch=0;
        while((ch=bais.read())!=-1)
            System.out.print((char)ch);


    }
}
