package com.lingjian.singleton;

/**
 * @description: 懒汉式（线程安全 同步方法）
 * @author: Ling Jian
 * @date: 2020-07-07 10:13
 **/
public class singleton04 {
    private static singleton04 instance =null;

    private singleton04(){}

    public synchronized static singleton04 getInstance(){
        if(instance==null){
            instance = new singleton04();

        }
        return instance;
    }
}
