package com.lingjian;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-01-02 10:02
 **/
public class LoadDemo {
    public static void main(String[] args) throws Exception {
        System.out.println(LoadDemo.class.getClassLoader());
        Class c = LoadDemo.class.getClassLoader().loadClass("com.lingjian.G");
//        Class c = Class.forName("com.lingjian.G");
        System.out.println(c.getClassLoader());
    }
}
