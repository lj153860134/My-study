package com.lingjian_1;

/**
 * @description: JVM内存测试
 * @author: Ling Jian
 * @date: 2019-12-26 10:00
 **/
public class Demo1 {
    public static void main(String[] args) throws Exception{
        System.out.println("1----");
        Thread.sleep(20000);
        byte[] array=new byte[1024*1024*100]; //10mb
        System.out.println("2----");
        Thread.sleep(20000);
        array=null;
        System.gc();
        System.out.println("3----");
        Thread.sleep(200000);


    }

}
