package com.lingjian_1.mybatis.io;

import java.io.InputStream;

/**
 * @description: 使用类加载器读取配置文件的类
 * @author: Ling Jian
 * @date: 2020-01-13 16:20
 **/
public class Resources {
    /**
     * 根据传入的参数 获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
