package com.lingjian.singleton;

/**
 * @description: 懒汉式（线程不安全）
 * @author: Ling Jian
 * @date: 2020-07-07 10:13
 **/
public class singleton03 {
    private static singleton03 instance =null;

    private singleton03(){}

    public static singleton03 getInstance(){
        if(instance==null){
            instance = new singleton03();

        }
        return instance;
    }
}
