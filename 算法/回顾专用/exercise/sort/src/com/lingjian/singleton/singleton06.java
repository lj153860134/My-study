package com.lingjian.singleton;

/**
 * @description: 静态内部类（推荐使用）
 * @author: Ling Jian
 * @date: 2020-07-07 10:13
 **/
public class singleton06 {
    private singleton06(){}

    private static class Singleton06Instance{
        private static final singleton06 INSTANCE = new singleton06();
    }

    public static singleton06 getInstance(){
        return Singleton06Instance.INSTANCE;
    }
}
