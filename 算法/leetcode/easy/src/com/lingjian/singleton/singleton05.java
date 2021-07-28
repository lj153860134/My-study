package com.lingjian.singleton;

/**
 * @description: DLC (double lock check)  推荐使用
 * @author: Ling Jian
 * @date: 2020-07-07 10:13
 **/
public class singleton05 {
    //一定要加volatile 不然会有指令重排饿危害
    //导致可能某个线程获得的instance为初始化完成
    private static volatile singleton05 instance = null;

    private singleton05() {
    }

    public static singleton05 getInstance() {
        if (instance == null) {
            synchronized (singleton05.class) {
                if (instance == null) {
                    instance = new singleton05();
                }
            }
        }
        return instance;
    }
}
