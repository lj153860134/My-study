package com.lingjian.singleton;

/**
 * @description: 饿汉式（静态常量）
 * @author: Ling Jian
 * @date: 2020-07-07 10:13
 **/
public class singleton01 {
    private static singleton01 instance = new singleton01();
    private singleton01(){}

    public static singleton01 getInstance(){
        return instance;
    }
}
