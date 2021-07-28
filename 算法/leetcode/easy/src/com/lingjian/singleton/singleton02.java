package com.lingjian.singleton;

/**
 * @description: 饿汉式（静态代码块）
 * @author: Ling Jian
 * @date: 2020-07-07 10:13
 **/
public class singleton02 {
    private static singleton02 instance =null;
    static {
        instance = new singleton02();
    }
    private singleton02(){}

    public static singleton02 getInstance(){
        return instance;
    }
}
