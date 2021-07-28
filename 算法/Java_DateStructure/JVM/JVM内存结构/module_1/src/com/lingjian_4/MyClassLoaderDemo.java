package com.lingjian_4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @description: 自定义类加载器
 * @author: Ling Jian
 * @date: 2020-01-02 10:48
 **/

public class MyClassLoaderDemo{
    public static void main(String[] args) throws ClassNotFoundException{
        MyClassLoader classLoader=new MyClassLoader();
        classLoader.loadClass("H");
    }

}
 class MyClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //class的文件路径
        String path="/Users/lingjian/Desktop/"+name+".class";
        try{
            //字节输出流
            ByteArrayOutputStream os=new ByteArrayOutputStream();
            //将class文件拷贝到一个字节输出流中
            Files.copy(Paths.get(path),os);
            //得到字节数组
            byte[] bytes = os.toByteArray();
            //调用父类的方法
            //将字节数组转换为.class文件
            return defineClass(name,bytes,0,bytes.length);

        }catch (IOException e){
            e.printStackTrace();
            throw new ClassNotFoundException("类文件未找到");
        }
    }
}
